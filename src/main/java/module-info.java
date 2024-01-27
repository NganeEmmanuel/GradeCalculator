module com.gradecalculator.gradecalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires bcrypt;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.gradecalculator.gradecalculator to javafx.fxml;
    opens com.gradecalculator.gradecalculator.controller;
    opens com.gradecalculator.gradecalculator.dao;
    opens com.gradecalculator.gradecalculator.service;
    opens com.gradecalculator.gradecalculator.helper;
    opens com.gradecalculator.gradecalculator.model;
    exports com.gradecalculator.gradecalculator;
    exports com.gradecalculator.gradecalculator.controller;
    exports com.gradecalculator.gradecalculator.dao;
    exports com.gradecalculator.gradecalculator.service;
    exports com.gradecalculator.gradecalculator.helper;
    exports com.gradecalculator.gradecalculator.model;
}