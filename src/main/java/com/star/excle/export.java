package com.star.excle;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.CharPool;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class export {


    private final String filePath = "D://";

    public void exportInfo(){
        // // 构建文件
        // LocalDate now = LocalDate.now();
        // String timeDir = "" + now.getYear() + CharPool.SLASH + now.getMonthValue() + CharPool.SLASH + now.getDayOfMonth();
        // String dir = filePath + timeDir;
        // FileUtil.mkdir(dir);
        // String fileName = IdUtil.fastSimpleUUID() + CharPool.DOT + 'xlsx';
        // File file = new File(dir + CharPool.SLASH + fileName);
        //
        // OutputStream os = Files.newOutputStream(file.toPath());
        // // System.setProperty("javax.xml.accessExternalSchema", dir + CharPool.SLASH);
        // System.setProperty("javax.xml.accessExternalSchema", "all");
        // if (exportRequest.getMode().equals(formDataExportUtils.MODE_ALL)) {
        //     // 创建 ExcelWriter 对象
        //     ExcelWriter excelWriter = EasyExcel.write(os)
        //             .autoCloseStream(true)
        //             .excelType(StrUtil.equals(type, formDataExportUtils.TYPE_XLSX) ? ExcelTypeEnum.XLSX : ExcelTypeEnum.CSV)
        //             .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
        //             .registerConverter(new ExcelBigNumberConvert()).build();
        //     int count = 30000;
        //     int offset = 0;
        //     while (true) {
        //         // 全数据分批导出, 30000一处理，
        //         List<Map> rows = formDataUtils.searchAllByLimit(queryFormResultRequest, offset, count);
        //         if (CollUtil.isEmpty(rows)) {
        //             break;
        //         }
        //         List<List<String>> dataList = listData(rows, fields, headMap);
        //         // 创建 SheetBuilder 对象
        //         WriteSheet writeSheet = EasyExcel.writerSheet(exportRequest.getSheetName()).head(headList).build();
        //         excelWriter.write(dataList, writeSheet);
        //         offset += count;
        //         rows.clear();
        //     }
        //     excelWriter.finish();
        //     log.info("导出全量问卷数据成功！");
        // } else {
        //     FormDataTableVO search = formDataUtils.search(queryFormResultRequest);
        //     List<Map> rows = search.getRows();
        //     // 数据处理
        //     List<List<String>> dataList = listData(rows, fields, headMap);
        //     EasyExcel.write(os)
        //             .autoCloseStream(true)
        //             .excelType(StrUtil.equals(type, formDataExportUtils.TYPE_XLSX) ? ExcelTypeEnum.XLSX : ExcelTypeEnum.CSV)
        //             .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
        //             .registerConverter(new ExcelBigNumberConvert())
        //             .sheet(exportRequest.getSheetName())
        //             .head(headList)
        //             .doWrite(dataList);
        //     log.info("导出部分问卷数据成功！");
        // }
        // os.close();
        // // 配置回默认值
        // System.clearProperty("javax.xml.accessExternalSchema");
        //
        // // 修改文件路径信息
        // GfFileCenterEntity entity = gfFileCenterMapper.selectById(event.getGfFileCenter().getId());
        // // 若以被删除
        // if (ObjectUtil.isNull(entity)){
        //     if (file.exists()) {
        //         file.delete();
        //     }
        // }else {
            // 更新业务数据
            // entity.setFileUrl(timeDir + CharPool.SLASH + fileName);
            // entity.setFileType(exportRequest.getType());
            // if (file.exists()) {
            //     entity.setFileSize((file.length() / 1024D));
            // }
        }

    }
