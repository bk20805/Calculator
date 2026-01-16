import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
	JFrame frame;
	JTextField field;
	JButton[] numbersB = new JButton[10];
	JButton[] functionsB = new JButton[9];
	JButton addB, subB, mulB, divB, decimalB,equalB, delB, clearB, negB;
	JPanel panel;
	Font myFont = new Font("Serif", Font.BOLD,25);
	double num1 = 0;
	double num2 = 0;
	double result = 0;
	char operators;  //add, sub, mul, div
	
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 500);
		frame.getContentPane().setBackground(new Color(0, 120, 200));
		frame.setLayout(null);
		
		
		field = new JTextField();
		field.setBounds(50, 25, 300, 50);
		field.setFont(myFont);
		field.setEditable(false);
		
		addB = new JButton("+");
		subB = new JButton("-");
		mulB = new JButton("*");
		divB = new JButton("÷");
		decimalB = new JButton(".");
		equalB = new JButton("=");
		delB = new JButton("Delete");
		clearB = new JButton("Clear");
		negB = new JButton("(-)");
		
		functionsB[0] = addB;
		functionsB[1] = subB;
		functionsB[2] = mulB;
		functionsB[3] = divB;
		functionsB[4] = decimalB;
		functionsB[5] = equalB;
		functionsB[6] = delB;
		functionsB[7] = clearB;
		functionsB[8] = negB;
		
		for(int i=0;i<9;i++) {
			functionsB[i].addActionListener(this);
			functionsB[i].setFont(myFont);
			functionsB[i].setFocusable(false);
			
		}
		
		for(int i=0;i<10;i++) {
			numbersB[i] = new JButton(String.valueOf(i));
			numbersB[i].addActionListener(this);
			numbersB[i].setFont(myFont);
			numbersB[i].setFocusable(false);
	
		}
		negB.setBounds(50,400, 70,50);
		delB.setBounds(115,400,150,50);
		clearB.setBounds(250,400,100,50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,15));
		panel.setBackground(Color.YELLOW);
		
		panel.add(numbersB[1]);
		panel.add(numbersB[2]);
		panel.add(numbersB[3]);
		panel.add(addB);
		panel.add(numbersB[4]);
		panel.add(numbersB[5]);
		panel.add(numbersB[6]);
		panel.add(subB);
		panel.add(numbersB[7]);
		panel.add(numbersB[8]);
		panel.add(numbersB[9]);
		panel.add(mulB);
		panel.add(decimalB);
		panel.add(numbersB[0]);
		panel.add(equalB);
		panel.add(divB);
		

		frame.add(field);
		frame.add(delB);
		frame.add(negB);
		frame.add(clearB);
		frame.add(panel);
		
		
		
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource()==numbersB[i]) {
				field.setText(field.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decimalB) {
			field.setText(field.getText().concat("."));
		}
		if(e.getSource()==addB) {
			num1 = Double.parseDouble(field.getText());
			operators='+';
			field.setText("");
			
		}
		if(e.getSource()==subB) {
			num1 = Double.parseDouble(field.getText());
			operators = '-';
			field.setText("");
		}
		if(e.getSource()==mulB) {
			num1 = Double.parseDouble(field.getText());
			operators = '*';
			field.setText("");
		}
		if(e.getSource()==divB) {
			num1 = Double.parseDouble(field.getText());
			operators = '÷';
			field.setText("");	
		}
		if(e.getSource()==equalB) {
			num2 = Double.parseDouble(field.getText());
			switch(operators) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '÷':
				result = num1/num2;
				break;
			}
			field.setText(String.valueOf(result));
			num1=result; //to reuse the result
		}
		if(e.getSource()==clearB) {
			field.setText("");
		}
		if(e.getSource()==delB) {
			String str = field.getText();
			field.setText("");
			for(int i=0;i<str.length()-1;i++) {
				field.setText(field.getText()+str.charAt(i));
			}
		}
		if(e.getSource()==negB) {
			double temp = Double.parseDouble(field.getText());
			temp*=-1;
			field.setText(String.valueOf(temp));
		}
	}

}
