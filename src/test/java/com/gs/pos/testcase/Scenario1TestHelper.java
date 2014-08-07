package com.gs.pos.testcase;

import com.accenture.mobility.swv.POSTestSupport;
import org.springframework.beans.factory.annotation.Value;
import sun.net.www.content.image.png;

public class Scenario1TestHelper extends POSTestSupport {


    @Value("${POS_MANAGEMENT}")
    String POS_MANAGEMENT;

    @Value("${PRODUCT_INSERT}")
    String PRODUCT_INSERT;

    @Value("${PRODUCT_BARCODE_INSERT}")
    String PRODUCT_BARCODE_INSERT;

    @Value("${PRODUCT_SAVE}")
    String PRODUCT_SAVE;

    @Value("${INVALID_BARCODE}")
    String INVALID_BARCODE;

}
