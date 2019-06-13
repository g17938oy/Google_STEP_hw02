import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
 
public class Matrix extends Application {
    static double[] data; 
   

    
    @Override
    public void start(Stage stage) throws Exception {
    	stage.setTitle("Bar Chart");
	CategoryAxis x = new CategoryAxis();
	x.setLabel("N");
	NumberAxis y = new NumberAxis();
	y.setLabel("Time");
 
	BarChart<String, Number> chart = new BarChart<String, Number>(x, y);
	chart.setTitle("Time by N");
	XYChart.Series<String, Number> xy = new XYChart.Series<>();
	xy.setName("Time");

		
	// Seriesにデータを設定
	for(int i = 2;i < data.length;i++) {
	    xy.getData().add(new XYChart.Data<>(String.valueOf(i), data[i]));
	}
		
	chart.getData().add(xy);
 
	HBox root = new HBox();
	root.getChildren().add(chart);
	Scene scene = new Scene(root, 600, 400);
	stage.setScene(scene);
	stage.show();
    }


       public static void  makeData() {
	int max = 300;
	data = new double[max];
	for(int n = 2; n < max; n++) {

	    double[][] a = new double[n][n]; // Matrix A
	    double[][] b = new double[n][n]; // Matrix B
	    double[][] c = new double[n][n]; // Matrix C

	    // Initialize the matrices to some values.
	    int i, j;
	    for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
		    a[i][j] = i * n + j;
		    b[i][j] = j * n + i;
		    c[i][j] = 0;
		}
	    }

	    long begin = System.currentTimeMillis();

	    /**************************************/
	    /* Write code to calculate C = A * B. */
	    /**************************************/

	    int k;
	    double s = 0.0;
	  
    
	    for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
		    for (k = 0; k < n; k++) {
			s = s + a[i][k] * b[k][j];
		    }
	  
		    c[i][j] = s;
		    s = 0;
		}     
	    }
    
	  

	    long end = System.currentTimeMillis();
	
	    data[i] = (end- begin)/1000.0;
	    
	    // Print C for debugging. Comment out the print before measuring the execution time.
	    double sum = 0;
	    for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
		    sum += c[i][j];
		    //System.out.printf("c[%d][%d]=%f\n", i, j, c[i][j]);
		}
	    }
	    // Print out the sum of all values in C.
	    // This should be 450 for N=3, 3680 for N=4, and 18250 for N=5.
	    //System.out.printf("sum: %.6f\n", sum);
	  	  
	}

    }
 
    public static void main(String... args) {
	makeData();
	launch(args);
    }


    
}
