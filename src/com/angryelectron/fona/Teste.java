package com.angryelectron.fona;

import java.io.File;
import java.util.List;
import java.util.Properties;

//+5511921836160
public class Teste {
    public static void main(String[] args) {
        Fona f = new Fona();
        FonaSerial serial = new FonaSerial();
      /*  try {
            serial.open("COM9", 9600);
            FonaSms sms = new FonaSms(serial);
            sms.delete(1);
            sms.delete(2);
            sms.delete(3);
            sms.delete(4);
            sms.delete(5);
            sms.delete(6);
            sms.delete(7);
            serial.close();
        } catch (FonaException e) {
            throw new RuntimeException(e);
        }
*/
        try {
            f.open("COM9", 9600);
            List<FonaSmsMessage> messages = f.smsRead(FonaSmsMessage.Folder.ALL, true);
            for (FonaSmsMessage sms : messages) {
                System.out.println(sms.sender + ": " + sms.message);
            }
            f.close();
        } catch (FonaException e) {
            throw new RuntimeException(e);
        }
    }


}
