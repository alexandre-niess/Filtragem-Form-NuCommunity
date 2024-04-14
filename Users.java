import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.io.FileReader;

//QTDE LINHAS 1088

public class Users {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("dados.txt"));
            String entrada[] = new String[1277];
            for (int i = 0; i < 1277; i++) {
                entrada[i] = br.readLine();
            }

            for (int i = 0; i < 1277; i++) {
                int aux = i + 1;
                System.out.println("LINHA " + aux);

                try {
                    pegaDados(entrada[i]);
                } catch (IOException e) {

                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo");
        }
    }

    // pega dados do usuário e analisa
    public static void pegaDados(String User) throws IOException {
        try {
            String url = "https://comunidade.nubank.com.br/u/" + User + ".json";

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            FileWriter file = new FileWriter("output.txt", true);
            FileWriter arquivo = new FileWriter("erros.txt", true);

            if (conn.getResponseCode() != 200) {
                System.out.println("ERRO \n");
                arquivo.write(User + " ERRO" + "\n");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output = "";
            String line;

            while ((line = br.readLine()) != null) {
                output += line;
            }
            // split da string por virgula:
            String[] parts = output.split(",");

            String Criação = "created_at";
            String Data = "";

            String Postslidos = "time_read";
            String Leitura = "";
            conn.disconnect();

            for (int i = 0; i < parts.length; i++) {

                if (parts[i].contains(Criação)) {
                    Data = formataString(parts[i]);
                    i = parts.length;
                }
            }

            for (int i = 0; i < parts.length; i++) {
                if (parts[i].contains(Postslidos)) {
                    Leitura = formataLeitura(parts[i]);
                    i = parts.length;
                }

            }

            String[] Date = Data.split("-");
            int dia = 0;
            int mes = 0;
            try {
                
 
            // parse para inteiro
            int ano = Integer.parseInt(Date[0]);// ANO

            if (Date[2].charAt(0) == '0') { // DIA
                dia = Integer.parseInt(String.valueOf(Date[2].charAt(1)));
            } else {
                dia = Integer.parseInt(Date[2]);
            }

            if (Date[1].charAt(0) == '0') { // MES
                mes = Integer.parseInt(String.valueOf(Date[1].charAt(1)));
            } else {
                mes = Integer.parseInt(Date[1]);
            }
            
                int leitura = Integer.parseInt(Leitura);
                boolean passou = false;
                if (!((dia > 8) && (mes == 2) && (ano == 2024))) {
                    if (leitura > 20000) {
                        passou = true;
                    }
                }
                if (passou) {
                    file.write(User + " " + "OK" + "\n");
                    System.out.println("PRINTOU " + User + "\n");
                } else {
                    file.write(User + " ELIMINADO" + "\n");
                    System.out.println("PRINTOU " + User + "\n");
                }
            } catch (NumberFormatException e) {
                FileWriter arquivoo = new FileWriter("erros.txt", true);
                FileWriter saida = new FileWriter("output.txt", true);
                System.out.println("ERRO \n");
                arquivoo.write(User + " ERRO" + "\n");
                saida.write(User + " ERRO" + "\n");
                arquivoo.close();
                saida.close();
            }

            file.close();
        } catch (IOException e) {
            FileWriter arquivo = new FileWriter("erros.txt", true);
            FileWriter saida = new FileWriter("output.txt", true);
            arquivo.write(User + " ERRO" + "\n");
            saida.write(User + " ERRO" + "\n");
            arquivo.close();
            saida.close();
        }
    }

    public static String formataLeitura(String str) {
        String reverse = "";
        for (int i = 12; i <= str.length() - 1; i++) {
            if (str.charAt(i) != ',') {
                reverse += str.charAt(i);
            }
        }
        return reverse;
    }

    // formata string
    public static String formataString(String str) {
        String reverse = "";
        for (int i = 14; i <= 23; i++) {
            reverse += str.charAt(i);
        }
        return reverse;
    }
}