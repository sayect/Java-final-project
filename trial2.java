import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.ImageIcon;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
public class trial2 extends Application{
	Double[] num = new Double[4];
	// private ImageView imageView;
	static Timer tim;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	//	Timer tim = new Timer(1000,1000);
	 
		
	
		Image Crd1 = new Image("1.png");
		Image Crd2 = new Image("2.jpg");
		Image Crd3 = new Image("3.png");
		Image Crd4 = new Image("4.png");
		Image Crd5 = new Image("5.png");
		Image Crd6 = new Image("6.png");
		Image Crd7 = new Image("7.png");
		Image Crd8 = new Image("8.png");
		Image Crd9 = new Image("9.png");
		Image Crd10 = new Image("10.jpg");
		Image Crd11 = new Image("11.jpg");
		Image Crd12 = new Image("12.jpg");
		Image Crd13 = new Image("13.png");
		
		ImageView pic1 = new ImageView();
		ImageView pic2 = new ImageView();
		ImageView pic3 = new ImageView();
		ImageView pic4 = new ImageView();
		
		
		
		 Random generator1 = new Random();
		 Random generator2 = new Random();
		 Random generator3 = new Random();
		 Random generator4 = new Random();
		 
         Button shuffleBtn = new Button("Shuffle");
		 Button solutionBtn = new Button("Solution");
		 TextField solutionTxt = new TextField(" ");
		 Label expressionLbl = new Label("Expression: ");
	     Button verifyBtn = new Button("Verify");
	     TextField AnswerTxt = new TextField(" ");
	     TextField Time = new TextField("0:0:0");
	    // Text T1 = new Text();
	     Text T2 = new Text();
	     Text T3 = new Text();
	     Text T4 = new Text();
	     
	     
	     
	     GridPane grid = new GridPane(); //sets up grid and the sizing
			grid.setPadding(new Insets (20,20,20,20));
			grid.setVgap(10);
			grid.setHgap(10);
	     
	     GridPane.setConstraints(shuffleBtn, 2, 1);
	     grid.getChildren().add(shuffleBtn);
	     GridPane.setConstraints(solutionBtn, 18, 1);
	     grid.getChildren().add(solutionBtn);
	     GridPane.setConstraints(solutionTxt, 9, 1);
	     grid.getChildren().add(solutionTxt);
	     GridPane.setConstraints(expressionLbl, 2, 17);
	     grid.getChildren().add(expressionLbl);
	     GridPane.setConstraints(verifyBtn, 18, 17);
	     grid.getChildren().add(verifyBtn);
	     GridPane.setConstraints(AnswerTxt, 9, 17);
	     grid.getChildren().add(AnswerTxt);
	     GridPane.setConstraints(Time, 2, 15);
	     grid.getChildren().add(Time);
	     
	     pic1.setFitWidth(130);
		pic1.setFitHeight(130);
		pic2.setFitWidth(130);
		pic2.setFitHeight(130);
		pic3.setFitWidth(130);
		pic3.setFitHeight(130);
		pic4.setFitWidth(130);
		pic4.setFitHeight(130);
		
		//GridPane.setConstraints(T1, 2, 10);
	//	grid.getChildren().add(T1);
		GridPane.setConstraints(T2, 9, 10);
		grid.getChildren().add(T2);
		GridPane.setConstraints(T3, 12, 10);
		grid.getChildren().add(T3);
		GridPane.setConstraints(T4, 19, 10);
		grid.getChildren().add(T4);
		
		//grid.add(pic1, 4, 8);
	     
	     //Random Number Generator
	         
	     
		
		//	pic.setImage(img);
		verifyBtn.setOnMouseClicked(action -> {
			
		TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                
            }
        };
        tim.cancel();
        tim = new Timer();
        tim.scheduleAtFixedRate(timerTask, 1000, 100);
			
			
			
		});
		
		
shuffleBtn.setOnMouseClicked(action -> {
	
	
	tim = new Timer();
	TimerTask  tas = new TimerTask() {
		int milisec = 0;
		  int sec=0;
		 int min=0;
		 int hour=0;
		
		public void run() {
			milisec++;
			if(milisec>10)	{
		    	milisec=0;
		    	sec++;
		    }
		    if(sec>60)	{
		    	milisec=0;
		    	sec=0;
		    	min++;
		    }
		    if(min>60)	{
		    	milisec=0;
		    	sec=0;
		    	min=0;
		    	hour++;
		    }
		    
		    Time.setText( hour + " : " + min + " : " + sec  );
		    
		}
		
	}; 
	tim.scheduleAtFixedRate(tas, 1000, 100);
	
	

	grid.getChildren().remove(pic1);
	grid.getChildren().remove(pic2);
	grid.getChildren().remove(pic3);
	grid.getChildren().remove(pic4);
	int num1 = generator1.nextInt(13) + 1;
	int num2 = generator2.nextInt(13) + 1;
	int num3 = generator3.nextInt(13) + 1;
	int num4 = generator4.nextInt(13) + 1;
	//T1.setText("rand:  " + num1);
	//T2.setText("rand:   " + num2);
	//T3.setText("rand:   " + num3);
	//T4.setText("rand:   " + num4);
	
	
		switch (num1) {
        case 1: 
        	pic1.setImage(Crd1);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 2: 
        	pic1.setImage(Crd2);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 3: 
        	pic1.setImage(Crd3);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 4:  
        	pic1.setImage(Crd4);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 5: 
       	pic1.setImage(Crd5);
       	GridPane.setConstraints(pic1, 4, 8);
		grid.getChildren().add(pic1);
                 break;
        case 6:  
        	pic1.setImage(Crd6);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 7:
        	pic1.setImage(Crd7);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 8: 
        	pic1.setImage(Crd8);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 9:  
        	pic1.setImage(Crd9);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 10: 
        	pic1.setImage(Crd10);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 11: 
        	pic1.setImage(Crd11);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 12: 
        	pic1.setImage(Crd12);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
                 break;
        case 13: 
        	pic1.setImage(Crd13);
        	GridPane.setConstraints(pic1, 4, 8);
    		grid.getChildren().add(pic1);
    	
            break;
            
        
    }
 
		
		
		switch (num2) {
        case 1: 
        	pic2.setImage(Crd1);
        	grid.add(pic2, 9, 8);
        	
                 break;
        case 2: 
        	pic2.setImage(Crd2);
        	grid.add(pic2, 9, 8);
                 break;
        case 3: 
        	pic2.setImage(Crd3);
        	grid.add(pic2, 9, 8);
                 break;
        case 4:  
        	pic2.setImage(Crd4);
        	grid.add(pic2, 9, 8);
                 break;
        case 5: 
        	pic2.setImage(Crd5);
        	grid.add(pic2, 9, 8);
                 break;
        case 6:  
        	pic2.setImage(Crd6);
        	grid.add(pic2, 9, 8);
                 break;
        case 7:
        	pic2.setImage(Crd7);
        	grid.add(pic2, 9, 8);
                 break;
        case 8: 
        	pic2.setImage(Crd8);
        	grid.add(pic2, 9, 8);
                 break;
        case 9:  
        	pic2.setImage(Crd9);
        	grid.add(pic2, 9, 8);
                 break;
        case 10: 
        	pic2.setImage(Crd10);
        	grid.add(pic2, 9, 8);
                 break;
        case 11: 
        	pic2.setImage(Crd11);
        	grid.add(pic2, 9, 8);
                 break;
        case 12: 
        	pic2.setImage(Crd12);
        	grid.add(pic2, 9, 8);
                 break;
        case 13: 
        	pic2.setImage(Crd13);
        	grid.add(pic2, 9, 8);
            break;
      
    }
		
		
		
		switch (num3) {
        case 1: 
        	pic3.setImage(Crd1);
        	grid.add(pic3, 14, 8);
                 break;
        case 2: 
        	pic3.setImage(Crd2);
        	grid.add(pic3, 14, 8);
                 break;
        case 3: 
        	pic3.setImage(Crd3);
        	grid.add(pic3, 14, 8);
                 break;
        case 4:  
        	pic3.setImage(Crd4);
        	grid.add(pic3, 14, 8);
                 break;
        case 5: 
        	pic3.setImage(Crd5);
        	grid.add(pic3, 14, 8);
                 break;
        case 6:  
        	pic3.setImage(Crd6);
        	grid.add(pic3, 14, 8);
                 break;
        case 7:
        	pic3.setImage(Crd7);
        	grid.add(pic3, 14, 8);
                 break;
        case 8: 
        	pic3.setImage(Crd8);
        	grid.add(pic3, 14, 8);
                 break;
        case 9:  
        	pic3.setImage(Crd9);
        	grid.add(pic3, 14, 8);
                 break;
        case 10: 
        	pic3.setImage(Crd10);
        	grid.add(pic3, 14, 8);
                 break;
        case 11: 
        	pic3.setImage(Crd11);
        	grid.add(pic3, 14, 8);
                 break;
        case 12: 
        	pic3.setImage(Crd12);
        	grid.add(pic3, 14, 8);
                 break;
        case 13: 
        	pic3.setImage(Crd13);
        	grid.add(pic3, 14, 8);
            break;
     
    }
		
		
		
		
		
		switch (num4) {
        case 1: 
        	pic4.setImage(Crd1);
        	grid.add(pic4, 18, 8);
                 break;
        case 2: 
        	pic4.setImage(Crd2);
        	grid.add(pic4, 18, 8);
                 break;
        case 3: 
        	pic4.setImage(Crd3);
        	grid.add(pic4, 18, 8);
                 break;
        case 4:  
        	pic4.setImage(Crd4);
        	grid.add(pic4, 18, 8);
                 break;
        case 5: 
        	pic4.setImage(Crd5);
        	grid.add(pic4, 18, 8);
                 break;
        case 6:  
        	pic4.setImage(Crd6);
        	grid.add(pic4, 18, 8);
                 break;
        case 7:
        	pic4.setImage(Crd7);
        	grid.add(pic4, 18, 8);
                 break;
        case 8: 
        	pic4.setImage(Crd8);
        	grid.add(pic4, 18, 8);
                 break;
        case 9:  
        	pic4.setImage(Crd9);
        	grid.add(pic4, 18, 8);
                 break;
        case 10: 
        	pic4.setImage(Crd10);
        	grid.add(pic4, 8, 8);
                 break;
        case 11: 
        	pic4.setImage(Crd11);
        	grid.add(pic4, 8, 8);
                 break;
        case 12: 
        	pic4.setImage(Crd12);
        	grid.add(pic4, 8, 8);
                 break;
        case 13: 
        	pic4.setImage(Crd13);
        	grid.add(pic4, 8, 8);
            break;
  
    }
		
       
       });



	
    
	
        	
        	
     
        
       

		
		Scene sn = new Scene (grid, 1000,500);  //adds the grid to the scene
		
		
		   
		 primaryStage.setTitle("24 Card Game");
	        primaryStage.setScene(sn);
	        primaryStage.show();
	}
	

	 public static void main(String[] args) {
	        Application.launch(args);
	    }
}