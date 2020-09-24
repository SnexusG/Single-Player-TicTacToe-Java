package tictactoe_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tictactoe {

	private JFrame frame;
	private String startGame = "X";
	private int[][] winPos= {{0,1,2}, {3,4,5}, {6,7,8}, {2,4,6}, {0,4,8}, {0,3,6}, {1,4,7},{2,5,8} }; 
	private boolean[] used = {false, false, false, false, false, false, false, false, false};
	private String[] board = {"1","1","1","1","1","1","1","1","1"};
	private int count = 0;
    int compUsed[] = {10,10,10,10,10,10,10,10,10};
    int c = 0;
    int turn = 0;
    int delay = 500;
    
	//Button Start
	JButton btn1 = new JButton("");
	JButton btn2 = new JButton("");
	JButton btn3 = new JButton("");
	JButton btn4 = new JButton("");
	JButton btn5 = new JButton("");
	JButton btn6 = new JButton("");
	JButton btn7 = new JButton("");
	JButton btn8 = new JButton("");
	JButton btn9 = new JButton("");
    //Button End
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tictactoe window = new tictactoe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tictactoe() {
		initialize();
	}

	
	public void playerTurn() {
		if(startGame.equalsIgnoreCase("X")) {
			startGame = "0";
		}else {
			startGame = "X";
		}
		checkWinner();
	}
	
	public void turn(JButton tempB, int n) {
		System.out.println("Turn : " + turn);
		tempB.setText(startGame);
		if(startGame.equalsIgnoreCase("X")) {
			tempB.setForeground(Color.RED);
			board[n] = "X";
		}else {
			tempB.setForeground(Color.BLUE);
			board[n] = "0";
		}
		//System.out.println(board[n]);
		playerTurn();
		count++;
		turn++;
		if(turn %2 == 1) {
			Timer timer = new Timer( delay, new ActionListener(){
				  @Override
				  public void actionPerformed( ActionEvent e ){
				    computersTurn();
				  }
				} );
				timer.setRepeats( false );
				timer.start();
		}
	}
	
	
	public void checkWinner() {
		int chk = 0;
		for(int i = 0; i < 8; i++) {
			if( (board[winPos[i][0]] == "X") && (board[winPos[i][0]] == board[winPos[i][1]]) && (board[winPos[i][1]] == board[winPos[i][2]] )) {
				//x has won
				System.out.println("X has won");
				JOptionPane.showMessageDialog(frame, "X has won!");
				chk = 1;
				for(int j = 0; j < 9; j++) {
					used[j] = true;
				}
			}else if((board[winPos[i][0]] == "0") && (board[winPos[i][0]] == board[winPos[i][1]]) && (board[winPos[i][1]] == board[winPos[i][2]] ) ) {
				//o has won
				System.out.println("0 has won");
				JOptionPane.showMessageDialog(frame, "0 has won!");
				chk = 1;
				for(int j = 0; j < 9; j++) {
					used[j] = true;
				}
			}
			}
		if(count == 8 && chk == 0){
				//draw
				System.out.println("DRAW");
				chk = 1;
				JOptionPane.showMessageDialog(frame, "It's a  Draw!");
				for(int j = 0; j < 9; j++) {
					used[j] = true;
				}
			}
		}
	

	public int computersTurn() {

	        int rand = (int)(Math.random() * 9);
	        boolean test = true;
	        if(c < 9) {
	        	if(!used[4] ){
	        		rand = 4;
	        	}else if((used[0] && used[1]) && !used[2] && ( (board[0] == "X" && board[1] == "X") ||  (board[0] == "0" && board[1] == "0") ) ){
	        		rand = 2;
	        	}else if((used[1] && used[2]) && !used[0] && ( (board[1] == "X" && board[2] == "X") ||  (board[1] == "0" && board[2] == "0") )) {
	        		rand = 0;
	        	}else if((used[0] && used[2]) && !used[1] && ( (board[0] == "X" && board[2] == "X") ||  (board[0] == "0" && board[2] == "0") )) {
	        		rand = 1;
	        	}else if((used[3] && used[4]) && !used[5] && ( (board[3] == "X" && board[4] == "X") ||  (board[3] == "0" && board[4] == "0") )) {
	        		rand = 5;
	        	}else if((used[4] && used[5]) && !used[3] && ( (board[4] == "X" && board[5] == "X") ||  (board[4] == "0" && board[5] == "0") )) {
	        		rand = 3;
	        	}else if((used[3] && used[5]) && !used[4] && ( (board[3] == "X" && board[5] == "X") ||  (board[3] == "0" && board[5] == "0") )) {
	        		rand = 4;
	        	}else if((used[6] && used[7]) && !used[8] && ( (board[6] == "X" && board[7] == "X") ||  (board[6] == "0" && board[7] == "0") )) {
	        		rand = 8;
	        	}else if((used[7] && used[8]) && !used[6] && ( (board[7] == "X" && board[8] == "X") ||  (board[7] == "0" && board[8] == "0") )) {
	        		rand = 6;
	        	}else if((used[6] && used[8]) && !used[7] && ( (board[6] == "X" && board[8] == "X") ||  (board[6] == "0" && board[8] == "0") )) {
	        		rand = 7;
	        	}else if((used[0] && used[3]) && !used[6] && ( (board[0] == "X" && board[3] == "X") ||  (board[0] == "0" && board[3] == "0") )) {
	        		rand = 6;
	        	}else if((used[3] && used[6]) && !used[0] && ( (board[3] == "X" && board[6] == "X") ||  (board[3] == "0" && board[6] == "0") )) {
	        		rand = 0;
	        	}else if((used[0] && used[6]) && !used[3] && ( (board[0] == "X" && board[6] == "X") ||  (board[0] == "0" && board[6] == "0") )) {
	        		rand = 3;
	        	}else if((used[1] && used[4]) && !used[7] && ( (board[1] == "X" && board[4] == "X") ||  (board[1] == "0" && board[4] == "0") )) {
	        		rand = 7;
	        	}else if((used[4] && used[7]) && !used[1] && ( (board[4] == "X" && board[7] == "X") ||  (board[4] == "0" && board[7] == "0") )) {
	        		rand = 1;
	        	}else if((used[1] && used[7]) && !used[4] && ( (board[1] == "X" && board[7] == "X") ||  (board[1] == "0" && board[7] == "0") )) {
	        		rand = 4;
	        	}else if((used[2] && used[5]) && !used[8] && ( (board[2] == "X" && board[5] == "X") ||  (board[2] == "0" && board[5] == "0") )) {
	        		rand = 8;
	        	}else if((used[5] && used[8]) && !used[2] && ( (board[5] == "X" && board[8] == "X") ||  (board[5] == "0" && board[8] == "0") )) {
	        		rand = 2;
	        	}else if((used[2] && used[8]) && !used[5] && ( (board[2] == "X" && board[8] == "X") ||  (board[2] == "0" && board[8] == "0") )) {
	        		rand = 5;
	        	}else if((used[0] && used[4]) && !used[8] && ( (board[0] == "X" && board[4] == "X") ||  (board[0] == "0" && board[4] == "0") )) {
	        		rand = 8;
	        	}else if((used[4] && used[8]) && !used[0] && ( (board[4] == "X" && board[8] == "X") ||  (board[4] == "0" && board[8] == "0") )) {
	        		rand = 0;
	        	}else if((used[0] && used[8]) && !used[4] && ( (board[0] == "X" && board[8] == "X") ||  (board[0] == "0" && board[8] == "0") )) {
	        		rand = 4;
	        	}else if((used[2] && used[4]) && !used[6] && ( (board[2] == "X" && board[4] == "X") ||  (board[2] == "0" && board[4] == "0") )) {
	        		rand = 6;
	        	}else if((used[4] && used[6]) && !used[2] && ( (board[4] == "X" && board[6] == "X") ||  (board[4] == "0" && board[6] == "0") )) {
	        		rand = 2;
	        	}else if((used[2] && used[6]) && !used[4] && ( (board[2] == "X" && board[6] == "X") ||  (board[2] == "0" && board[6] == "0") )) {
	        		rand = 4;
	        	}
	        	else {
		       while((used[rand]  || test)) {
		    	   test = false;
		    	   
		           rand = (int)(Math.random() * 9);
		    	   for(int i : compUsed) {
		    		   if(rand == i) {
		    			   test = true;
		    		   }
		    	   }
		    	   if(!test) {
		    		   compUsed[c] = rand;
		    	   }
		    	   
		       }
	        	}
	        	
	    	compUsed[c] = rand;
	    	c++;
		    used[rand] = true;
		       checkWinner();
		       switch(rand) {
		 
		       case 0: turn(btn1 ,0);
		       			break;
		       			
		       case 1: turn(btn2 ,1);
	  				break;
	  			
		       case 2: turn(btn3 ,2);
	  				break;

		       case 3: turn(btn4 ,3);
	  				break;
	  			
		       case 4: turn(btn5 ,4);
	  				break;

		       case 5: turn(btn6 ,5);
	  				break;
	  			
		       case 6: turn(btn7 ,6);
	  				break;
	  			
		       case 7: turn(btn8 ,7);
	  				break;
		    	 
		       case 8: turn(btn9 ,8);
	  				break;
	 
		       }

		       return rand;
	        }
	        return 0;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 2, 2, 2));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 3, 2, 2));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		

		btn1.setForeground(Color.RED);

		btn1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				if(!used[0]) {
				turn(btn1,0);
				used[0] = true;
				}

			}
			
		});
		

		
		btn1.setBackground(Color.BLACK);
		btn1.setFont(new Font("Ravie", Font.PLAIN, 60));
		
		panel_3.add(btn1, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
	
		btn2.setForeground(Color.GREEN);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!used[1]) {
				turn(btn2,1);
				used[1] = true;
				}

			}
		
		});


		btn2.setBackground(Color.BLACK);
		btn2.setFont(new Font("Ravie", Font.PLAIN, 60));
		
		panel_4.add(btn2, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		

		btn3.setForeground(Color.GREEN);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!used[2]) {
				turn(btn3,2);
				used[2] = true;
				}

			}
		});

		
		btn3.setBackground(Color.BLACK);
		btn3.setFont(new Font("Ravie", Font.PLAIN, 60));
		panel_5.add(btn3, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!used[3]) {
				turn(btn4,3);
				used[3] = true;
				}
	
			}
		});

		
		btn4.setBackground(Color.BLACK);
		btn4.setFont(new Font("Ravie", Font.PLAIN, 60));
		panel_6.add(btn4, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		if(turn %2 == 0) {
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!used[4]) {
				turn(btn5, 4);
				used[4] = true;
				}
			}
		});

		btn5.setBackground(Color.BLACK);
		btn5.setFont(new Font("Ravie", Font.PLAIN, 60));
		panel_7.add(btn5, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		

		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!used[5]) {
				turn(btn6,5);
				used[5] = true;
				}

				}
			});

		
		btn6.setBackground(Color.BLACK);
		btn6.setFont(new Font("Ravie", Font.PLAIN, 60));
		panel_8.add(btn6, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		

		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!used[6]) {
				turn(btn7,6);
				used[6] = true;
				}

			}
		});
	
		
		btn7.setBackground(Color.BLACK);
		btn7.setFont(new Font("Ravie", Font.PLAIN, 60));
		panel_9.add(btn7, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		

		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!used[7]) {
				turn(btn8,7);
				used[7] = true;
				}

			}
		});

		
		btn8.setBackground(Color.BLACK);
		btn8.setFont(new Font("Ravie", Font.PLAIN, 60));
		panel_10.add(btn8, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		

		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!used[8]) {
				turn(btn9,8);
				used[8] = true;
				}

			}
		});

		
		btn9.setBackground(Color.BLACK);
		btn9.setFont(new Font("Ravie", Font.PLAIN, 60));
		panel_11.add(btn9, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 2, 2));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.BLACK);
		panel_2.add(panel_12);
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText(null);
				btn2.setText(null);
				btn3.setText(null);
				btn4.setText(null);
				btn5.setText(null);
				btn6.setText(null);
				btn7.setText(null);
				btn8.setText(null);
				btn9.setText(null);
				for(int i = 0; i < 9; i++) {
					used[i] = false;
					board[i] = "1";
					compUsed[i] = 10;
				}
			    c = 0;
			    turn = 0;
			    count = 0;
			    startGame = "X";
			}
		});
		btnReset.setForeground(Color.PINK);
		btnReset.setBackground(Color.DARK_GRAY);
		btnReset.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 40));
		panel_12.add(btnReset);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.BLACK);
		panel_2.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("EXIT");
				if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setForeground(Color.PINK);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 40));
		panel_13.add(btnExit);
	}
	}
}
