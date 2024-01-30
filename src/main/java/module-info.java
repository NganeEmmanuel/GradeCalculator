module com.gradecalculator.gradecalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires bcrypt;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.gradecalculator.gradecalculator to javafx.fxml;
    opens com.gradecalculator.gradecalculator.controller;
    opens com.gradecalculator.gradecalculator.dao.persitentInit;
    opens com.gradecalculator.gradecalculator.dao.EntityDao;
//    opens com.gradecalculator.gradecalculator.service;
//    opens com.gradecalculator.gradecalculator.helper;
    opens com.gradecalculator.gradecalculator.model;
    exports com.gradecalculator.gradecalculator;
    exports com.gradecalculator.gradecalculator.controller;
    exports com.gradecalculator.gradecalculator.dao.persitentInit;
    exports com.gradecalculator.gradecalculator.dao.EntityDao;
    exports com.gradecalculator.gradecalculator.helper.enums;
    exports com.gradecalculator.gradecalculator.model;
    exports com.gradecalculator.gradecalculator.service.userService;
    opens com.gradecalculator.gradecalculator.service.userService;
    exports com.gradecalculator.gradecalculator.service.studentService;
    opens com.gradecalculator.gradecalculator.service.studentService;
    exports com.gradecalculator.gradecalculator.service.loginService;
    opens com.gradecalculator.gradecalculator.service.loginService;
}