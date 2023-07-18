/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Inputter {

    public String inputString(String msg) {
        Scanner in = new Scanner(System.in);
        //Vong lap bat nguoi dung nhap lai den khi nhap dung thi thoi
        while (true) {
            System.out.print(msg);
            String str = in.nextLine().trim();
            if (str.isEmpty()) { //Khong duoc de trong
                System.err.println("Can't be empty. Please try again.");
            } else {
                return str;
            }
        }
    }
}
