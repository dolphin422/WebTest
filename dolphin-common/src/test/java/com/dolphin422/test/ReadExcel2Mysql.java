package com.dolphin422.test;

import com.dolphin422.common.util.UUIDGenerator;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018.07.03 11:01
 */
public class ReadExcel2Mysql {


    @Test
    public void getExcel() throws Exception {
        String sorFilePath = "D:\\0000山西购买服务\\政府购买服务目录\\test";
        List<HSSFWorkbook> workbookList = getExcelList(sorFilePath);
        System.out.println("数据长度值 workbookList---->" + workbookList.size());
        List<GuidingCatalogue> allGuidingCatalogueList = new ArrayList<>(workbookList.size());
        for (HSSFWorkbook workbook : workbookList) {
            List<GuidingCatalogue> fileVoList = changeExcel2Vo(workbook);
            allGuidingCatalogueList.addAll(fileVoList);
        }
        Gson gson = new Gson();
        String json = gson.toJson(allGuidingCatalogueList);
        System.out.println("数据 json---->" + json);
        System.out.println("数据长度值 allGuidingCatalogueList---->" + allGuidingCatalogueList.size());
    }

    /**
     * 获取本地EXCEL数据
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public List<HSSFWorkbook> getExcelList(String filePath) throws Exception {
        List<HSSFWorkbook> workbookList = new ArrayList<>();
        File file = new File(filePath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File fileExcel = files[i];
                FileInputStream fileInputStream = new FileInputStream(fileExcel);
                //String name = fileExcel.getName();
                //String absolutePath = fileExcel.getAbsolutePath();
                HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(fileInputStream));
                workbookList.add(workbook);
            }
        }
        return workbookList;
    }

    /**
     * 转换Excel到Vo
     *
     * @param workbook
     * @return
     */
    public List<GuidingCatalogue> changeExcel2Vo(HSSFWorkbook workbook) {
        List<GuidingCatalogue> tarGuidingCatalogueList = new ArrayList<>();
        //获取页签:获取一共有多少sheet，可遍历
        //int numberOfSheets = workbook.getNumberOfSheets();
        //只取第一个sheet
        HSSFSheet sheet = workbook.getSheetAt(0);
        //第一行是标题 单位信息等
        HSSFRow firstRow = sheet.getRow(0);
        HSSFCell titleCell = firstRow.getCell(0);
        String titleName = titleCell.getStringCellValue();
        titleName = titleName.replace("购买服务指导性目录", "");
        GuidingCatalogue rootGuidingCatalogue = new GuidingCatalogue();
        String rootUUId = UUIDGenerator.getUUID();
        rootGuidingCatalogue.setCatalogGuid(rootUUId);
        rootGuidingCatalogue.setCatalogName(titleName);
        rootGuidingCatalogue.setCatalogNode("1");
        HSSFCell codeCell = firstRow.getCell(1);
        String orgCode = codeCell.getStringCellValue();
        rootGuidingCatalogue.setCatalogCode(orgCode);
        rootGuidingCatalogue.setPurSubjectName(titleName);
        rootGuidingCatalogue.setPurSubjectCode(orgCode);
        tarGuidingCatalogueList.add(rootGuidingCatalogue);
        //获取sheet中一共有多少行，从第三行开始数据数据
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        //判断父子关系
        GuidingCatalogue preCatalogue2 = new GuidingCatalogue();
        GuidingCatalogue preCatalogue3 = new GuidingCatalogue();
        GuidingCatalogue preCatalogue4 = new GuidingCatalogue();

        //从第三行开始
        for (int j = 2; j < numberOfRows; j++) {
            GuidingCatalogue guidingCatalogue = new GuidingCatalogue();
            String uuid = UUIDGenerator.getUUID();
            guidingCatalogue.setPurSubjectName(titleName);
            guidingCatalogue.setPurSubjectCode(orgCode);
            guidingCatalogue.setRegionCode("140001");
            guidingCatalogue.setCatalogGuid(uuid);
            //取该行
            HSSFRow row = sheet.getRow(j);
            //取列  第一列是编码
            HSSFCell cell0 = row.getCell(0);
            if (null != cell0) {
                String stringCellValue = cell0.getStringCellValue();
                if (StringUtils.isNotBlank(stringCellValue)) {
                    guidingCatalogue.setCatalogCode(stringCellValue);
                    String catalogOrder = this.getCatalogOrder(stringCellValue);
                    Integer catalogOrderInt = Integer.valueOf(catalogOrder);
                    guidingCatalogue.setCatalogCodeOrder(catalogOrderInt);
                } else {
                    break;
                }
            } else {
                break;
            }

            //取列  第二列:一级目录
            HSSFCell cell1 = row.getCell(1);
            if (null != cell1) {
                String stringCellValue = cell1.getStringCellValue();
                if (StringUtils.isNotBlank(stringCellValue)) {
                    guidingCatalogue.setCatalogName(stringCellValue);
                    guidingCatalogue.setCatalogNode("2");
                    guidingCatalogue.setFatherCatalogCode(rootGuidingCatalogue.getCatalogCode());
                    guidingCatalogue.setFatherCatalogName(rootGuidingCatalogue.getFatherCatalogName());
                    guidingCatalogue.setFatherCatalogGuid(rootGuidingCatalogue.getCatalogGuid());
                    preCatalogue2 = guidingCatalogue;
                }
            }
            // 第三列:二级目录
            HSSFCell cell2 = row.getCell(2);
            if (null != cell2) {
                String stringCellValue = cell2.getStringCellValue();
                if (StringUtils.isNotBlank(stringCellValue)) {
                    guidingCatalogue.setCatalogName(stringCellValue);
                    guidingCatalogue.setCatalogNode("3");
                    guidingCatalogue.setFatherCatalogCode(preCatalogue2.getCatalogCode());
                    guidingCatalogue.setFatherCatalogName(preCatalogue2.getFatherCatalogName());
                    guidingCatalogue.setFatherCatalogGuid(preCatalogue2.getCatalogGuid());
                    preCatalogue3 = guidingCatalogue;
                }
            }
            // 第四列:三级目录
            HSSFCell cell3 = row.getCell(3);
            if (null != cell3) {
                String stringCellValue = cell3.getStringCellValue();
                if (StringUtils.isNotBlank(stringCellValue)) {
                    guidingCatalogue.setCatalogName(stringCellValue);
                    guidingCatalogue.setCatalogNode("4");
                    guidingCatalogue.setFatherCatalogCode(preCatalogue3.getCatalogCode());
                    guidingCatalogue.setFatherCatalogName(preCatalogue3.getFatherCatalogName());
                    guidingCatalogue.setFatherCatalogGuid(preCatalogue3.getCatalogGuid());
                    preCatalogue4 = guidingCatalogue;
                }
            }
            // 第五列:四级目录内容
            HSSFCell cell4 = row.getCell(4);
            if (null != cell4) {
                String stringCellValue = cell4.getStringCellValue();
                if (StringUtils.isNotBlank(stringCellValue)) {
                    guidingCatalogue.setCatalogName(stringCellValue);
                    guidingCatalogue.setCatalogNode("5");
                    guidingCatalogue.setFatherCatalogCode(preCatalogue4.getCatalogCode());
                    guidingCatalogue.setFatherCatalogName(preCatalogue4.getFatherCatalogName());
                    guidingCatalogue.setFatherCatalogGuid(preCatalogue4.getCatalogGuid());
                }
            }
            tarGuidingCatalogueList.add(guidingCatalogue);
        }
        return tarGuidingCatalogueList;
    }

    private String getCatalogOrder(String stringCellValue) {
        String catalogOrder;
        if (stringCellValue.toLowerCase().endsWith("a")) {
            catalogOrder = "01";
        } else if (stringCellValue.toLowerCase().endsWith("b")) {
            catalogOrder = "02";
        } else if (stringCellValue.toLowerCase().endsWith("c")) {
            catalogOrder = "03";
        } else if (stringCellValue.toLowerCase().endsWith("d")) {
            catalogOrder = "04";
        } else if (stringCellValue.toLowerCase().endsWith("e")) {
            catalogOrder = "05";
        } else if (stringCellValue.toLowerCase().endsWith("f")) {
            catalogOrder = "06";
        } else if (stringCellValue.toLowerCase().endsWith("g")) {
            catalogOrder = "07";
        } else if (stringCellValue.toLowerCase().endsWith("h")) {
            catalogOrder = "08";
        } else {
            int length = stringCellValue.length();
            catalogOrder = stringCellValue.substring(length - 2, length);
        }
        return catalogOrder;
    }

    @Test
    public void gsonTest() {
        Gson gson = new Gson();
        List<String> strList = new ArrayList<>();
        strList.add("aaaa");
        strList.add("bbbbb");
        strList.add("cccc");
        String s = gson.toJson(strList);
        System.out.println("s值 ---->" + s);
    }


}
