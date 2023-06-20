package Atm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class atnwodb {
	static SortedSet <String>ac_no = new TreeSet();
	static LinkedList <String>names = new LinkedList();
	static LinkedList <Integer> pin = new LinkedList();
	static LinkedList <Integer> bal = new LinkedList(); 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ac_no.add("ab10020001"); ac_no.add("ab10020002"); ac_no.add("ab10020003"); ac_no.add("ab10020004");
		names.add("krishna"); names.add("hemasri"); names.add("rajpaul"); names.add("docter");
		pin.add(1234); pin.add(5200); pin.add(5858); pin.add(7894);
		bal.add(5000); bal.add(32000); bal.add(8989); bal.add(58000);
		System.out.println("enter application number:");
		String acno = sc.nextLine();
		System.out.println("enter pin:");
	    int  pinu = sc.nextInt();
	    int i=0;
	    int j=0;
	    int end=1;
		for(String str:ac_no) {
			if(acno.equals(str)) {
				for(int pinv: pin) {
//					System.out.println(i+" "+j);
//					System.out.println(pinv);
					if(pinv==pinu && i==j) {
						while(true) {
							System.out.println("1 for withdraw 2 for deposite 3 for balence 4 for pinchange");
							int x=sc.nextInt();
						switch(x){
							case 1:{
							withdraw(acno,i);
							break;
						}
							case 2: {
							deposite(acno,i);
							break;
						}
							case 3: {
							balence(acno,i);
						}
							case 4:{
								int pinc = sc.nextInt();
								pin.set(i,pinc);
								break;}
							case 5:{
								System.exit(0);
							}
						}
						}
				}
				else if(i!=j && j+1==pin.size()) {
				System.out.println("wrong pin");
				System.exit(0);}
					j++;
			}
		}
			else if(end==ac_no.size()) {
				System.err.println("wrong a/c no");
				System.out.println("create account 1 and close 2");
				int ip= sc.nextInt();
				if(ip==1) {
					create();
					atnwodb atm = new atnwodb();
					atm.main(args);
				}
	}
			i++;	
			end++;
	}
	}
	private static void create() {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("select accno:");
		String ac = sc.nextLine();
		ac_no.add(ac);
		System.out.println("enter name:");
		String name=sc.nextLine();
		names.add(name);
		System.out.println("select pin:");
		int pins = sc.nextInt();
		pin.add(pins);
		System.out.println("initial balence");
		int bali = sc.nextInt();
		bal.add(bali);
	}
	public static void deposite(String acno, int i) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int depi=0;
		for(int depv:bal) {
			if(depi==i) {
				int ip=sc.nextInt();
				bal.set(depi, (ip+depv));
				balence(acno,i);
				break;
			}
			depi++;
		}
		
	}
	public static void balence(String acno, int i) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int bali=0;
		for(int balv:bal) {
			if(bali==i) {
				System.out.println("your balence is:"+balv);
				break;
			}
			bali++;
		}
	}
	private static void withdraw(String acno, int i) {
		// TODO Auto-generated method stub
		int withi=0;
		Scanner sc =new Scanner(System.in);
		for(int withv:bal) {
			if(withi==i) {
				System.out.println("enetr amount to withdraw :");
				int with= sc.nextInt();
				bal.set(withi, (withv-with));
				balence(acno,i);
				break;
			}
		}
	}
	
}
