package org.vaadin.olli;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VaadinView extends VerticalLayout {
    Grid<Data> grid;

    public VaadinView() {
        setSizeFull();
        setupTabs();
    }

    private void setupTabs() {
        Map<Tab, Component> tabsToPages = new HashMap<>();
        Tab tmfTab = new Tab("Tab A");
        Div tmfDiv = initializeTabA();
        tabsToPages.put(tmfTab, tmfDiv);

        Tab ibrTab = new Tab("Tab B");
        Div ibrDiv = initializeTabB();
        ibrDiv.setVisible(false);
        tabsToPages.put(ibrTab, ibrDiv);

        Tabs tabs = new Tabs(tmfTab, ibrTab);
        Div pages = new Div(tmfDiv, ibrDiv);
        Set<Component> pagesShown = Stream.of(tmfDiv).collect(Collectors.toSet());
        tabs.addSelectedChangeListener(event -> {
            pagesShown.forEach(page -> page.setVisible(false));
            pagesShown.clear();
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
            pagesShown.add(selectedPage);
        });
        tabs.setSizeFull();
        pages.setSizeFull();
        add(tabs);
        add(pages);
        this.setFlexGrow(10.0d, pages);
    }

    // Goal here is for table to grow vertically
    // to use up entire height of browser window
    // but still use table scrolling when needed
    Div initializeTabA() {
        Div div = new Div();
        div.setSizeFull();
        // Adding in VerticalLayout made no difference, tried it to use flexGrow.
        VerticalLayout vl = new VerticalLayout();
        vl.setSizeFull();
        div.add(vl);

        grid = new Grid<Data>();
        Grid.Column<Data> aCol = grid.addColumn(Data::getA).setHeader("A");
        Grid.Column<Data> bCol = grid.addColumn(Data::getB).setHeader("B");
        Grid.Column<Data> cCol = grid.addColumn(Data::getC).setHeader("C");

        List<Data> rows = new ArrayList<Data>();
        for (int i = 0; i < 13; i++) {
            rows.add(new Data("a1", "b1", "c1"));
        }
        grid.setItems(rows);
        vl.add(grid);
        vl.setFlexGrow(10.0, grid);
        return div;
    }

    Div initializeTabB() {
        Div div = new Div();
        div.setSizeFull();
        return div;
    }
}

