package demo;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.rapidpm.dependencies.core.logger.HasLogger;

@Route("")
public class VaadinJavaApp
    extends Composite<Div>
    implements HasLogger {

  private final Button         btn    = new Button("click me");
  private final VerticalLayout layout = new VerticalLayout(btn);

  private int clickcount = 0;

  public VaadinJavaApp() {


    btn.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
      @Override
      public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {

        Label      content    = new Label("Something important");
        DatePicker datePicker = new DatePicker();

        Button btnClose = new Button("Close");

        VerticalLayout innerLayout  = new VerticalLayout(content, datePicker, btnClose);
        Notification   notification = new Notification(innerLayout);
        notification.setPosition(Notification.Position.MIDDLE);
        notification.open();

        btnClose.addClickListener(buttonClickEvent1 -> notification.close());
      }
    });


    logger().info("and now..  setting the main content.. ");
    getContent().add(layout);
  }
}