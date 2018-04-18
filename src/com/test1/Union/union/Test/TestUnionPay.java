package com.test1.Union.union.Test;

import java.util.Scanner;

import com.test1.Union.union.UnionPay;
import com.test1.Union.unionImpl.ICBCImpl;

public class TestUnionPay {
	public static void main(String[] args) {
		UnionPay icbc=new ICBCImpl(2000,"123456");
		
		Scanner input=new Scanner(System.in);
		System.out.println("ÇëÊäÈëÃÜÂë£º");
		if(icbc.checkPwd(input.next())){
			System.out.println("ÇëÊäÈë½ğ¶î£º");
			double num=Double.parseDouble(input.next());
			if(icbc.drawMoney(num)){
				System.out.println("È¡Ç®³É¹¦£¬¿¨Óà¶îÎª£º"+icbc.getBalance());
			}else{
				System.out.println("È¡Ç®Ê§°Ü");
			}
		}else{
			System.out.println("ÃÜÂë´íÎó");
		}
	}
}
