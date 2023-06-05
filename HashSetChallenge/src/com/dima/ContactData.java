package com.dima;

import java.util.*;

public class ContactData {

    private static final String phoneData = """
            Charlie Brown, 3334445555
            Maid Marion, 1234567890
            Mickey Mouse, 9998887777
            Mickey Mouse, 1247489758
            Minnie Mouse, 4567805666
            Robin Hood, 5647893000
            Robin Hood, 7899028222
            Lucy Van Pelt, 5642086852
            Mickey Mouse, 9998887777
            """;

    private static final String emailData = """
            Mickey Mouse, mckmouse@gmail.com
            Mickey Mouse, micky1@aws.com
            Minnie Mouse, minnie@verizon.net
            Robin Hood, rhood@gmail.com
            Linus Van Pelt, lvpelt2015@gmail.com
            Daffy Duck, daffy@google.com
            """;

    public static List<Contact> getData(String dataType) {
        List<Contact> data = new ArrayList<>();
        Scanner scanner = new Scanner(dataType.equals("phone") ? phoneData : emailData);
        while(scanner.hasNext()) {
            String[] rawDataLine = scanner.nextLine().split(",");
            Arrays.asList(rawDataLine).replaceAll(String::trim);
            if(dataType.equals("phone")) {
                data.add(new Contact(rawDataLine[0], Long.parseLong(rawDataLine[1])));
            } else {
                data.add(new Contact(rawDataLine[0], rawDataLine[1]));
            }
        }
        return data;
    }
}
