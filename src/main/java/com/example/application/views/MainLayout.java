/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.application.views;

import com.example.application.security.SecurityService;
import com.example.application.views.list.ListView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 *
 * @author george
 */
public class MainLayout extends AppLayout {
    
    private final SecurityService securityService;
    
    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;
        createHeader();
        createDrawer();
    }
    
    private void createHeader() {
        H1 logo = new H1("Vaadin CRM");
        logo.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.MEDIUM);
        
        String user = securityService.getAuthenticatedUser().getUsername();
        Button logout = new Button("Log out " + user, e -> securityService.logout());
        
        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(), logo, logout);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidthFull();
        header.addClassNames(LumoUtility.Padding.Vertical.NONE,
                LumoUtility.Padding.Horizontal.MEDIUM);
        
        addToNavbar(header);
    }
    
    private void createDrawer(){
        addToDrawer(new VerticalLayout(
                new RouterLink("List", ListView.class),
                new RouterLink("Dashboard", DashboardView.class)
        ));
    }
}
