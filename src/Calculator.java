import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class Calculator extends JFrame implements ActionListener {
	Container cp = this.getContentPane();// 获得面容面板
	JPanel pane = new JPanel();// 新建中间容器
	JPanel pane1 = new JPanel();
	JPanel pane2 = new JPanel();
	JLabel text1 = new JLabel("输入:");
	JLabel text2 = new JLabel("计算结果:");
	JTextField j1 = new JTextField(120);
	JTextField j2 = new JTextField(120);
	String t;
	double h;

	// 新建按钮组件
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton b0 = new JButton("0");
	JButton a1 = new JButton("+");
	JButton a2 = new JButton("-");
	JButton a3 = new JButton("*");
	JButton a4 = new JButton("/");
	JButton a5 = new JButton("^");
	JButton a6 = new JButton("%");
	JButton a7 = new JButton(".");
	JButton a8 = new JButton("(");
	JButton a9 = new JButton(")");
	JButton a0 = new JButton("clear");
	JButton c = new JButton("=");

	// 构造方法
	public Calculator() {

		super("谢伟宁的简易计算器"); // 初始化界面
		setBounds(400, 400, 360, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cp.add(pane, BorderLayout.CENTER);// 添加到面容面板中
		cp.add(pane1, BorderLayout.NORTH);
		cp.add(pane2, BorderLayout.SOUTH);

		pane.setLayout(new GridLayout(5, 4, 6, 6));// 将面板改成是网格的
		pane1.setLayout(new GridLayout(0, 1, 12, 12));
		pane2.setLayout(new GridLayout());
		
		// 添加到中间面板中
		pane1.add(text1);
		pane1.add(j1);
		pane1.add(text2);
		pane1.add(j2);
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		pane.add(a1);
		pane.add(b4);
		pane.add(b5);
		pane.add(b6);
		pane.add(a2);
		pane.add(b7);
		pane.add(b8);
		pane.add(b9);
		pane.add(a3);
		pane.add(a6);
		pane.add(b0);
		pane.add(a5);
		pane.add(a4);
		pane.add(a8);
		pane.add(a9);
		pane.add(a7);
		pane.add(a0);
		pane2.add(c);

		// 添加监听器
		a1.addActionListener(this);
		a2.addActionListener(this);
		a3.addActionListener(this);
		a4.addActionListener(this);
		a5.addActionListener(this);
		a6.addActionListener(this);
		a7.addActionListener(this);
		a8.addActionListener(this);
		a9.addActionListener(this);
		a0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		c.addActionListener(this);

	}

	// 监听器的实现
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == b1)
			j1.setText(j1.getText() + b1.getText());
		if ((JButton) e.getSource() == b2)
			j1.setText(j1.getText() + b2.getText());
		if ((JButton) e.getSource() == b3)
			j1.setText(j1.getText() + b3.getText());
		if ((JButton) e.getSource() == b4)
			j1.setText(j1.getText() + b4.getText());
		if ((JButton) e.getSource() == b5)
			j1.setText(j1.getText() + b5.getText());
		if ((JButton) e.getSource() == b6)
			j1.setText(j1.getText() + b6.getText());
		if ((JButton) e.getSource() == b7)
			j1.setText(j1.getText() + b7.getText());
		if ((JButton) e.getSource() == b8)
			j1.setText(j1.getText() + b8.getText());
		if ((JButton) e.getSource() == b9)
			j1.setText(j1.getText() + b9.getText());
		if ((JButton) e.getSource() == b0)
			j1.setText(j1.getText() + b0.getText());
		if ((JButton) e.getSource() == a1)
			j1.setText(j1.getText() + a1.getText());
		if ((JButton) e.getSource() == a2)
			j1.setText(j1.getText() + a2.getText());
		if ((JButton) e.getSource() == a3)
			j1.setText(j1.getText() + a3.getText());
		if ((JButton) e.getSource() == a4)
			j1.setText(j1.getText() + a4.getText());
		if ((JButton) e.getSource() == a5)
			j1.setText(j1.getText() + a5.getText());
		if ((JButton) e.getSource() == a6)
			j1.setText(j1.getText() + a6.getText());
		if ((JButton) e.getSource() == a7)
			j1.setText(j1.getText() + a7.getText());
		if ((JButton) e.getSource() == a8)
			j1.setText(j1.getText() + a8.getText());
		if ((JButton) e.getSource() == a9)
			j1.setText(j1.getText() + a9.getText());
		if ((JButton) e.getSource() == a0)
			j1.setText("");
		if ((JButton) e.getSource() == c) {
			t=Change(j1.getText());    //变成后缀表达式
			System.out.println(t);
			h=Calc(t);
			j2.setText(""+String.format("%.4f", h));

		}
	}

	// 中缀表达式转成后缀表达式
	String Change(String infix) {
		Stack<Character> stack = new Stack<Character>();// 建立一个符号栈
		String suffix = ""; // 存放后缀表达式的字符串
		int length = infix.length();// 获得中缀表达式的长度
		for (int i = 0; i < length; i++) {
			Character temp;
			char c = infix.charAt(i); // 将字符串分成逐个字符
			switch (c) {

			case ' ': // 忽略空格
				break;

			case '(': // 碰到'('，push到栈
				stack.push(c);
				break;

			case ')':// 碰到右括号，将靠近栈顶的第一个左括号上面的运算符全部依次弹出，送至输出队列后，再丢弃左括号
				while (stack.size() != 0) {
					temp = stack.pop();
					if (temp == '('){
						break;
					}
					else{
						suffix += " " + temp;
				}
				}
				break;

			case '+': // 碰到'+''-'，将栈中所有运算符弹出，送到输出队列中
			case '-':
				while (stack.size() != 0) {
					temp = stack.pop();
					if (temp == '(') {
						stack.push('(');
					}else{
					suffix += " " + temp;
				}
				}
				stack.push(c);
				suffix += " ";
				break;

			case '*':// 碰到'*''/'，将栈中所有乘除运算符弹出，送到输出队列中,只有比他小的就进栈
			case '/':
			case '%':
				while (stack.size() != 0) {
					temp = stack.pop();

					if (temp == '(' || temp == '+' || temp == '-') {
						stack.push(temp);
						break;
					} else {
						suffix += " " + temp;
					}
				}
				stack.push(c);
				suffix += " ";
				break;

			case '^':// 遇到^的情况
				while (stack.size() != 0) {
					temp = stack.pop();
					if (temp == '(' || temp == '+' || temp == '-' || temp == '*' || temp == '%' || temp == '/'||temp=='^') {
						stack.push(temp);
						break;
					} else {
						suffix += " " + temp;
					}
				}
				stack.push(c);
				suffix += " ";
				break;

			default:     // 如果是数字，直接送至输出序列
				suffix += c;
			}
		}

		while (stack.size() != 0) { // 如果栈不为空，把剩余的运算符依次弹出，送至输出序列。
			suffix += " " + stack.pop();
		}
		return suffix;
	}

	// 通过后缀表达式求出算术结果
	double Calc(String postfix) {
		Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)"); // 使用正则表达式 //
																	// 匹配数字
		String strings[] = postfix.split(" "); // 将字符串转化为字符串数组
		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < strings.length; i++)
			strings[i].trim(); // 去掉字符串首尾的空格

		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals(""))
				continue;

			// 如果是数字，则进栈
			if ((pattern.matcher(strings[i])).matches()) {
				stack.push(Double.parseDouble(strings[i]));
			} else {
				// 如果是运算符，弹出运算数，计算结果。
				double y = stack.pop();
				double x = stack.pop();
				stack.push(getCalc(x, y, strings[i])); // 将运算结果重新压入栈。
			}
		}
		return stack.pop(); // 弹出栈顶元素就是运算最终结果。

	}

	// 获得表达式的值
	private static double getCalc(double x, double y, String simble) {
		if (simble.trim().equals("+"))
			return x + y;
		if (simble.trim().equals("-"))
			return x - y;
		if (simble.trim().equals("*"))
			return x * y;
		if (simble.trim().equals("/"))
			return x / y;
		if (simble.trim().equals("%"))
			return x % y;
		if (simble.trim().equals("^"))
			return Math.pow(x, y);
		return 0;
	}

	public static void main(String a[]) {
		Calculator calc = new Calculator();

	}

}
