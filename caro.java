


import java.io.UnsupportedEncodingException;
import java.util.*;


/*
 * co caro
 */
public class caro {
	/*
	 * khoi tao bang ban dau 
	 */
	static int row = 5;
	static int column = 5;
	static byte chon;
	static String a[][] = new String[row][column];
	
	
	/*
	 * ban co 
	 */
	public static void create_board() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				a[i][j] = "-";
			}
		}
	}

	
	/*
	 * xuat ban co 5x5
	 */
	public static void output() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(" " + a[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	
	/*
	 * duy chuyen cua co
	 */
	public static void inputCaro(int row, int clumn, String n) {
			a[row][clumn] = n;
	}
	
	
	/*
	 * Kiem tra dieu kien de duy chuyen cua ban co
	 */
	public static boolean is_legal_move(int row2, int column2, String n) {
		if (row2 < row && column2 < column && n.equalsIgnoreCase("X") || n.equalsIgnoreCase("O") ) {
					if (a[row2][column2] == "-") {
							return true;
					}
		}
		return false;
	}

	
	/*
	 * kiem tra co hop phap ko de thuc hien viec di chuyen
	 *
	 */
	public static void make_move(int row, int column, String n) {
		boolean bl = is_legal_move(row, column,n);
		if (bl == true) {
			System.out.print("\ndi chuyen hop phap \n");
			inputCaro(row, column, n);
			System.out.println("\n---------------");
			System.out.println("\nSau khi di chuyen \n ");
			output();
			System.out.println("\n---------------");
		} else {
			System.out.print("\n!!!! di chuyen (Ten) khong hop phap !!!!\n");
			System.out.println("\n---------------");
		}
	}
	
	/*
	 * chay bang random
	 */
	public static boolean inputRandom() {
		int h = 0;
		Random rd = new Random();
		do {	
				int value  = rd.nextInt(row);
				int value2 = rd.nextInt(column);
				if (a[value][value2] == "-") {
						inputCaro(value,value2,"O");
						if(checkWin(value, value2) == true) {
							System.out.println("O Thang");
							chon = 0; 
						}
						return true;
				} 
		}while( h == 0 );
		return false;
	}
	
	/*
	 * xuat random
	 */
	public static void make_moveO() {
		boolean bl = inputRandom();
		if (bl == true) {
			System.out.println("\n---------------");
			System.out.println("\nO Sau khi di chuyen \n ");
			output();
			System.out.println("\n---------------");
		}
	}
	
	
	/*
	 * xuat cac buoc duy chuyen
	 */
	public static void make_move_auto(int row, int column, String n) {
		boolean bl = is_legal_move(row, column,n);
		if (bl == true) {
			System.out.print("\ndi chuyen hop phap \n");
			inputCaro(row, column, n);
			System.out.println("\n---------------");
			System.out.println("\nX Sau khi di chuyen \n ");
			output();
			System.out.println("\n---------------");
			make_moveO();
		} else {
			System.out.print("\n!!!! di chuyen (Ten) khong hop phap !!!!\n");
			System.out.println("\n---------------");
		}
	}
	
	
	
	public static boolean checkWin(int i, int j)  {
		int d = 0, k = i ;
		
		if(i<row && j < column) {
			// so cot 
			while (k < row && a[k][j].equalsIgnoreCase(a[i][j]) ) {
				d++;
				k++;
			}
			
			k = i-1;
		
			while( k >= 0 && a[k][j].equalsIgnoreCase(a[i][j]) ) {
				d++;
				k--;
			}
			
			if(d > 4 ) {
				return true;
			}
			
			// so hang
			int d2 = 0, k2 = j;
			while(k2 < row && a[i][k2].equalsIgnoreCase(a[i][j])) {
				d2++;
				k2++;
			}
			k2 = j-1;
			while(k2 >= 0 && a[i][k2].equalsIgnoreCase(a[i][j]) ) {
				d2++;
				k2--;
			}
			
			if(d2 > 4) {
				return true;
			}
			
			
			// so duong cheo dau huyen
			int k3 =i , k4 = j, d3 =0;
			while(k3 < row && k4 < row && a[k3][k4].equalsIgnoreCase(a[i][j]) ) {
				d3++;
				k3++;
				k4++;
			}
			
			k3 = i-1;
			k4 = j-1;
			while(k3 >= 0 && k4 >= 0 && a[k3][k4].equalsIgnoreCase(a[i][j]) ) {
				d3++;
				k3--;
				k4--;
			}
			
			if(d3 > 4) {
				return true;
			}
			
			// dương chéo dau sat
			int k5 = i, k6 = j, d4 = 0;
			while(k5 >= 0 && k6 >= 0 && k5 < row && k6 < row && a[k5][k6].equalsIgnoreCase(a[i][j]) ) {
				d4++;
				k5++;
				
				k6--;
			}
			k5 = i-1;
			k6 = j+1; 
			while(k5 < row && k6 < row && k5 >= 0 && k6 >= 0 && a[k5][k6].equalsIgnoreCase(a[i][j])) {
				d4++;
				k5--;
				k6++;
			}
			if(d4 > 4) {
				return true;
			}
		}	
	
	//	System.out.println("false");
		return false;
	}
	
	

	public static void main(String args[]) throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("=========CO CARO========");
			System.out.println("Chon so 1 : choi mot nguoi ");
			System.out.println("Chon so 2 : choi hai nguoi ");
			System.out.println("Chon so 0 : thoat khoi tro choi ");
			System.out.print("Chon : "); 
			byte chon1 = sc.nextByte();
			if(chon1 == 2) {
					do {
						System.out.println("\n-----CO CARO HAI NGUOI CHOI------");
						System.out.println("chon 1 : Tao mang choi moi ");
						System.out.println("chon 2 : duy chuyen ");
						System.out.print("Chon  : ");
						chon = sc.nextByte();
						switch (chon) {
						case 1:
						create_board();
						output();
						break;
			
						case 2:
							create_board();
							output();
							System.out.println("\n---------------");
							System.out.print("\nNhap so hang :");
							int sh = sc.nextInt();
							System.out.print("So cot : ");
							int soc = sc.nextInt();
							System.out.print("Nhap ten : ");
							
							sc.nextLine();
							String w = sc.nextLine();
							System.out.println("\n---------------");
							System.out.print("\nKIEM TRA : ");
							make_move(sh, soc, w);
							
						
							if(checkWin(sh,soc) == true) {
								System.out.print(" thang  ");
									chon = 0 ;
							}
							
							break;
			
						default:
							chon = 0;
							break;
						}
					} while (chon != 0);
					
			} else if (chon1 == 1) {
				do {
					System.out.println("\n-----CO CARO MOT NGUOI CHOI------");
					System.out.println("chon 1: Tao mang choi moi ");
					System.out.println("chon 2: duy chuyen ");
					System.out.print("Chon  : ");
					chon = sc.nextByte();
					switch (chon) {
					case 1:
						create_board();
						output();
						break;
		
					case 2:
						System.out.println("\n---------------");
						System.out.print("\nNhap so hang X :");
						int sh = sc.nextInt();
						System.out.print("So cot  X : ");
						int soc = sc.nextInt();
						System.out.println("\n---------------");
						System.out.print("\nKIEM TRA : ");
						make_move_auto(sh, soc, "X");
						
						if( checkWin(sh,soc) == true ) {
							System.out.print(" X thang  ");
								chon = 0 ;
						}
						
						break;
		
					default:
						chon = 0;
						break;
					}
				} while (chon != 0);
			}
		sc.close();
	}while(chon !=0 );
	}
}