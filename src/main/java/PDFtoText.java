import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by i81269 on 2/24/2016.
 */
public class PDFtoText {

    public static void main(String[] args) {
        PDDocument pd;
        BufferedWriter wr;
        try {
            File input = new File("Constitution_of_Nepal-Final.pdf");  // The PDF file from where you would like to extract
            File output = new File("Constitution_of_Nepal-Final.txt"); // The text file where you are going to store the extracted data
            pd = PDDocument.load(input);
            System.out.println(pd.getNumberOfPages());
            System.out.println(pd.isEncrypted());
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(0); //Start extracting from page 3
            stripper.setEndPage(pd.getNumberOfPages()); //Extract till page 5
            wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
            stripper.writeText(pd, wr);

            if (pd != null) {
                pd.close();
            }
            // I use close() to flush the stream.
            fileConvert();
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileConvert() throws IOException {
        {
            FileInputStream in = null;
            FileOutputStream out = null;

            try {
                in = new FileInputStream("Constitution_of_Nepal-Final.txt");
                out = new FileOutputStream("Constitution_of_Nepal-Final-Unicode.txt");

                String line;
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(out, Charset.forName("UTF-8")));
                PreetyToUnicode converter = new PreetyToUnicode();
                while ((line = br.readLine()) != null) {
                    wr.write(converter.convert_to_unicode(line));
                    wr.newLine();
                }
            } finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
        }
    }
}
