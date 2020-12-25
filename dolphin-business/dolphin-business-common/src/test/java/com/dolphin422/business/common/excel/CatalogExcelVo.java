package com.dolphin422.business.common.excel;

import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019-11-13 17:07
 */
public class CatalogExcelVo {

    private HSSFWorkbook workbook;

    private String name;

    private List<GuidingCatalogue> guidingCatalogueList;

    private List<String> errorFileNameList;

    private int totalFileNum;

    private int errorFileNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(HSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public List<GuidingCatalogue> getGuidingCatalogueList() {
        return guidingCatalogueList;
    }

    public void setGuidingCatalogueList(
        List<GuidingCatalogue> guidingCatalogueList) {
        this.guidingCatalogueList = guidingCatalogueList;
    }

    public List<String> getErrorFileNameList() {
        return errorFileNameList;
    }

    public void setErrorFileNameList(List<String> errorFileNameList) {
        this.errorFileNameList = errorFileNameList;
    }

    public int getTotalFileNum() {
        return totalFileNum;
    }

    public void setTotalFileNum(int totalFileNum) {
        this.totalFileNum = totalFileNum;
    }

    public int getErrorFileNum() {
        return errorFileNum;
    }

    public void setErrorFileNum(int errorFileNum) {
        this.errorFileNum = errorFileNum;
    }
}
