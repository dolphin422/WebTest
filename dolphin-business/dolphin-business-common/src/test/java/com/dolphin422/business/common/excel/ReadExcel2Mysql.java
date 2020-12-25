package com.dolphin422.business.common.excel;

import com.dolphin422.common.util.DateUtil;
import com.dolphin422.common.util.UUIDGenerator;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018.07.03 11:01
 */
public class ReadExcel2Mysql {

    /**
     * logger
     */
    private Logger log = LoggerFactory.getLogger(ReadExcel2Mysql.class);


    @Test
    public void getExcel() throws Exception {
        String filePath = "D:\\0000山西购买服务\\政府购买服务目录\\test";
        List<CatalogExcelVo> excelList = this.getExcelList(filePath);
        log.info("数据长度值 excelList---->" + excelList.size());
        List<GuidingCatalogue> allGuidingCatalogueList = new ArrayList<>();
        int totalNum = 0;
        int errorNum = 0;
        List<String> errorFileNameList = new ArrayList<>();
        for (CatalogExcelVo catalogExcelVo : excelList) {
            totalNum++;
            List<GuidingCatalogue> guidingCatalogueList = new ArrayList<>();
            HSSFWorkbook workbook = catalogExcelVo.getWorkbook();
            String fileName = catalogExcelVo.getName();
            try {
                log.info("---序号:{}--fileName--{}", totalNum, fileName);
                guidingCatalogueList = changeExcel2Vo(workbook);
            } catch (Exception ex) {
                errorNum++;
                errorFileNameList.add(fileName);
                log.info("---序号:{}--errorFileName--{}", totalNum, fileName);

            }
            allGuidingCatalogueList.addAll(guidingCatalogueList);
        }
        //Gson gson = new Gson();
        //String json = gson.toJson(allGuidingCatalogueList);
        //System.out.println("数据 json---->" + json);
        log.info("数据长度值 allGuidingCatalogueList---->" + allGuidingCatalogueList.size());
        if (allGuidingCatalogueList.size() > 0) {
            for (GuidingCatalogue guidingCatalogue : allGuidingCatalogueList) {
                guidingCatalogue.setStartDate(DateUtil.getCurrentDateTime());
                guidingCatalogue.setEndDate(DateUtil.getCurrentDateTime());
                guidingCatalogue.setYear(2019);
            }
        }
        CatalogExcelVo result = new CatalogExcelVo();
        result.setGuidingCatalogueList(allGuidingCatalogueList);
        result.setTotalFileNum(totalNum);
        result.setErrorFileNum(errorNum);
        result.setErrorFileNameList(errorFileNameList);
    }

    /**
     * 获取本地EXCEL数据
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    private List<CatalogExcelVo> getExcelList(String filePath) throws Exception {
        List<CatalogExcelVo> workbookList = new ArrayList<>();
        File file = new File(filePath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File fileExcel = files[i];
                FileInputStream fileInputStream = new FileInputStream(fileExcel);
                String name = fileExcel.getName();
                //String absolutePath = fileExcel.getAbsolutePath();
                CatalogExcelVo catalogExcelVo = new CatalogExcelVo();
                HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(fileInputStream));
                catalogExcelVo.setWorkbook(workbook);
                catalogExcelVo.setName(name);
                workbookList.add(catalogExcelVo);
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
    private List<GuidingCatalogue> changeExcel2Vo(HSSFWorkbook workbook) {
        List<GuidingCatalogue> tarGuidingCatalogueList = new ArrayList<>();
        //获取页签:获取一共有多少sheet，可遍历
        //int numberOfSheets = workbook.getNumberOfSheets();
        //只取第一个sheet
        HSSFSheet sheet = workbook.getSheetAt(0);
        // int lastRowNum = sheet.getLastRowNum();

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
        //设置类型
        codeCell.setCellType(Cell.CELL_TYPE_STRING);
        String orgCode = codeCell.getStringCellValue();
        rootGuidingCatalogue.setCatalogCode(orgCode);
        rootGuidingCatalogue.setPurSubjectName(titleName);
        rootGuidingCatalogue.setPurSubjectCode(orgCode);
        rootGuidingCatalogue.setPurSubjectGuid(orgCode);
        tarGuidingCatalogueList.add(rootGuidingCatalogue);
        //获取sheet中一共有多少行，从第三行开始数据数据
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        //log.info("----------title:{}-----lastRowNum:{}-----numberOfRows:{}", titleName, lastRowNum,
        //   numberOfRows);
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
            guidingCatalogue.setPurSubjectGuid(orgCode);
            guidingCatalogue.setRegionCode("140001");
            guidingCatalogue.setCatalogGuid(uuid);
            //取该行
            HSSFRow row = sheet.getRow(j);
            //取列  第一列是编码
            HSSFCell cell0 = null;

            cell0 = row.getCell(0);

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
                    guidingCatalogue.setFatherCatalogName(rootGuidingCatalogue.getCatalogName());
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
                    guidingCatalogue.setFatherCatalogName(preCatalogue2.getCatalogName());
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
                    guidingCatalogue.setFatherCatalogName(preCatalogue3.getCatalogName());
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
                    guidingCatalogue.setFatherCatalogName(preCatalogue4.getCatalogName());
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
