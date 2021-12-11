package com.service.store.core.event;

import lombok.Data;

@Data
public class ReportEvent {
    private  String storeId;
    private  int report;
}
