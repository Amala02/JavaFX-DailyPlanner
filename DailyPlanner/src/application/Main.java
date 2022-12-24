package application;
	
import java.awt.MultipleGradientPaint.CycleMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.control.PasswordField;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {
	private Parent gp;

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		BorderPane gp= new BorderPane();
		//gp.setAlignment(Pos.CENTER);
		
		Scene scene= new Scene(gp);
		scene.getStylesheets().add("application.css");
		
		Text t1= new Text("Set timer");
		t1.setX(50);
		t1.setY(100);
		t1.setFont(new Font("Arial", 15));
		t1.setId("t1");
		
		ToggleGroup t_group = new ToggleGroup();  
		RadioButton off= new RadioButton("Off");
		RadioButton on= new RadioButton("On");
		on.setToggleGroup(t_group);
		off.setToggleGroup(t_group);
		on.setId("on");
		off.setId("off");
		
		HBox box= new HBox(20, on, off);
		//creating timer component
		Group timer= new Group(t1);
		timer.setId("timer");
		//creating menu component
		
		Menu menu = new Menu("menu");
		MenuItem m1= new MenuItem("profile");
		MenuItem m2= new MenuItem("exit");
		MenuItem m3= new MenuItem("connect");
		
		menu.getItems().add(m1);
		menu.getItems().add(m2);
		menu.getItems().add(m3);
		
		MenuBar mb = new MenuBar();
		mb.getMenus().add(menu);
		mb.setId("menubar");
		Group HOME= new Group(mb);
		
		
		
		

		
		//creating datepicker
		DatePicker d1= new DatePicker();
		Text l_calendar= new Text("Choose the day");
		l_calendar.setX(50);
		l_calendar.setY(100);
		l_calendar.setFont(new Font("Arial", 15));
		l_calendar.setId("calendar");
		//creating tasks component
		
		TextField task1= new TextField();
		TextField task2= new TextField();
		TextField task3= new TextField();
		
		CheckBox ctask1= new CheckBox();
		CheckBox ctask2= new CheckBox();
		
		Text tasks= new Text("Tasks to do!");
		tasks.setX(50);
		tasks.setY(100);
		tasks.setFont(new Font("Arial", 15));
		tasks.setId("tasks");
		//tasks.setStyle("-fx-background-color:LAVENDER");
		ToggleButton mode_light= new ToggleButton("Light");
		ToggleButton mode_dark= new ToggleButton("Dark");
		
		
		mode_dark.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	
		    	scene.getStylesheets().clear();
		    	scene.getStylesheets().add("dark.css");
		    	
		    }
		});
		mode_light.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				scene.getStylesheets().clear();
				scene.getStylesheets().add("application.css");
			
			}
			
		});
		
		
		ToggleGroup modes= new ToggleGroup();
		mode_dark.setToggleGroup(modes);
		mode_light.setToggleGroup(modes);
		
		
	   /* Group Image1 = new Group(light_imageview);
	    HBox image_box = new HBox();
	    image_box.getChildren().add(0, Image1);
	    image_box.setAlignment(Pos.CENTER);*/
	    
	    VBox time= new VBox();
	    VBox date= new VBox();
	    time.getChildren().add(0,timer);
	    time.getChildren().add(1, box);
	    date.getChildren().add(0,l_calendar);
	    date.getChildren().add(1, d1);	    
	    time.setId("time");
	    date.setId("date");
	    
	    time.setMaxSize(150,100);
	    time.setSpacing(10);
	    
	    date.setMaxSize(150,100);
	    //date.setStyle("-fx-background-color:LAVENDER");
	    
	    
	    
	    VBox Task_box= new VBox();
	    Task_box.getChildren().add(0, tasks);
	    Task_box.getChildren().add(1,ctask1);
	    Task_box.getChildren().add(2,task1);
	    Task_box.getChildren().add(3,ctask2);
	    Task_box.getChildren().add(4,task2);
	   
	    
	    Task_box.setMaxSize(200, 200);
	    Task_box.setSpacing(30);
	    
	    Task_box.setId("task_box");
		gp.setMinWidth(600);
		gp.setMinHeight(400);
		
		HBox modes_box= new HBox();
		modes_box.getChildren().add(0, mode_light);
		modes_box.getChildren().add(1, mode_dark);
		modes_box.setId("modes_box");
		
		HBox date_time= new HBox();
		date_time.getChildren().add(0, time);
		date_time.getChildren().add(1,date);
		
		VBox right= new VBox();
		right.getChildren().add(0,date_time);
		right.getChildren().add(1, Task_box);
		
		
		
		Text daily= new Text(30,50, "Daily");
	
		daily.setId("daily");
		
		Text planner= new Text(30,50, "Planner");
		
		planner.setId("Planner");
		
		//setting time display
		
		ZoneId india = ZoneId.of("Asia/Kolkata");
		ZonedDateTime currentZone = ZonedDateTime.now();
		ZonedDateTime indiaZone =
				currentZone.withZoneSameInstant(india);
		
		
		
		DateTimeFormatter format =
				DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			
		String formatedDateTime = indiaZone.format(format);
		
		
		Text currentTime= new Text(formatedDateTime);
		
		currentTime.setId("currentTime");
		
		VBox center= new VBox();
		center.getChildren().add(0,daily);
		center.getChildren().add(1,planner);
		center.getChildren().add(2, currentTime);
		center.setId("center");
		
		
		gp.setCenter(center);
		gp.setRight(right);
		gp.setBottom(modes_box);
	
		
		
		try {}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Comfortaa&display=swap");
		scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Comfortaa&display=swap");
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Daily Planner");
		primaryStage.show();
		
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}


