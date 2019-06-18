package org.vaadin.olli;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@BodySize(height = "100%", width = "100%")
@Theme(Lumo.class)
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class VaadinTest extends VerticalLayout {
    HorizontalLayout header;
    VaadinView vaadinView;

    public VaadinTest() {
        setSizeFull();
        init();
        setPadding(false);
        setSpacing(false);
        setMargin(false);
    }

    public void init() {
        header = new HorizontalLayout();
        header.setSpacing(true);
        header.setMargin(false);
        header.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        header.setJustifyContentMode(JustifyContentMode.START);
        header.setWidth("100%");
        add(header);

        Label appLabel = new Label("Vaadin Test");
        header.add(appLabel);
        Label userName = new Label("David Jordan");
        header.add(userName);

        vaadinView = new VaadinView();
        add(vaadinView);
    }


}
