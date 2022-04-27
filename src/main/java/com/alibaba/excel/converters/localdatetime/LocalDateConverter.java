package com.alibaba.excel.converters.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.DateUtils;
import com.alibaba.excel.util.WorkBookUtil;

public class LocalDateConverter implements Converter<LocalDate> {
    @Override
    public Class<LocalDate> supportJavaTypeKey() {
        return LocalDate.class;
    }

    @Override public WriteCellData<?> convertToExcelData(LocalDate value,
        ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {

        String format = null;
        if (contentProperty != null && contentProperty.getDateTimeFormatProperty() != null) {
            format = contentProperty.getDateTimeFormatProperty().getFormat();
        }
        WriteCellData<?> cellData = new WriteCellData<>(LocalDateTime.of(value.getYear(),value.getMonth(),value.getDayOfMonth(),0,0));
        WorkBookUtil.fillDataFormat(cellData, format, DateUtils.defaultDateFormat);
        return cellData;
    }
}
