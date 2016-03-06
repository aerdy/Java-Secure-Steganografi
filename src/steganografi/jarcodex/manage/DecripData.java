/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganografi.jarcodex.manage;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import javax.swing.JTextField;

/**
 *
 * @author Jarcode
 */
public class DecripData {
    public void Imagedecrypt(JTextField txtmessage,File filename, int key) throws java.io.IOException {
        FileInputStream ins = new FileInputStream(filename);
        byte b[] = new byte[2];
        BigInteger bb1;
        char mess[] = new char[8];
        int c = 0;
        for (int i = 0; i < key; i++) {
            int n = ins.read();
        }
        for (int i = 0; i < 8; i++) {
            ins.read(b);
            bb1 = new BigInteger(b);
            String str = bb1.toString(2);
            int len = bb1.bitLength();
            if (b[0] < 0) {
                len++;
            }
            char ch[] = new char[len + 1];
            str.getChars(0, len, ch, 0);
            if (b[0] == 0) {
                mess[i] = '0';
            } else {
                mess[i] = ch[len - 1];
            }
        }
        String dd = new String(mess);
        BigInteger bb = new BigInteger(dd, 2);
        String s = bb.toString(2);
        int l = bb.intValue();

        char me[] = new char[l];
        int count = 0;

        for (int m = 0; m < l; m++) {
            for (int i = 0; i < 8; i++) {
                ins.read(b);
                bb1 = new BigInteger(b);
                String str = bb1.toString(2);
                int len = bb1.bitLength();
                if (b[0] < 0) {
                    len++;
                }
                char ch[] = new char[len + 1];
                str.getChars(0, len, ch, 0);
                if (b[0] == 0) {
                    mess[i] = '0';
                } else {
                    mess[i] = ch[len - 1];
                }
            }
            String dd1 = new String(mess);
            BigInteger bb2 = new BigInteger(dd1, 2);
            String s1 = bb2.toString(2);
            int l1 = bb2.intValue();
            me[count] = (char) l1;
            count++;
        }
        String message = new String(me);
        txtmessage.setText(message);
        ins.close();
    }
}
