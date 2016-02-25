public class PreetyToUnicode {
    String[]  array_one = new String[]{

            "ç","˜",".","'m","]m","Fmf","Fm",

            ")","!","@","#","$","%","^","&","*","(",

            "k|m","em","km","Qm","qm","N˜",
            "¡","¢","1","2","4",">","?","B","I","Q","ß",
            "q","„","‹","•","›","§","°","¶","¿","Å",
            "Ë","Ì","Í","Î","Ý","å",
            "6«","7«","8«","9«",

            "Ø","|",

            "8Þ","9Þ",

            "S","s","V","v","U","u","£","3","ª",
            "R","r","5","H","h","‰","´","~", "`",

            "6","7","8","9","0",
            "T","t","Y","y","b","W","w","G","g",

            "K","k","ˆ","A","a","E", "e","D","d",
            "o","/","N","n","J", "j", "Z","z","i",":",";","X","x",

            "cf‘","c‘f","cf}","cf]","cf","c","O{","O","pm","p","C","P]","P",

            "f‘","\"","'","+","f","[","\\","]","}","F", "L","M",

            "्ा","्ो","्ौ","अो","अा","आै","आे","ाो","ाॅ","ाे",
            "ंु","ेे","अै","ाे","अे","ंा","अॅ","ाै","ैा","ंृ",
            "ँा","ँू","ेा","ंे"


    };// Remove typing mistakes in the original file

//"_","�","�","�","�","�","�","�","�","-","<","="};     // Remove typing mistakes in the original file

//"_","Ö","Ù","Ú","Û","Ü","Þ","Æ","±","-","<","=")    // Punctuation marks

    String[] array_two = new String[]{

            "ॐ","ऽ","।","m'","m]","mfF","mF",

            "०","१","२","३","४","५","६","७","८","९",

            "फ्र","झ","फ","क्त","क्र","ल",
            "ज्ञ्","द्घ","ज्ञ","द्द","द्ध","श्र","रु","द्य","क्ष्","त्त","द्म",
            "त्र","ध्र","ङ्घ","ड्ड","द्र","ट्ट","ड्ढ","ठ्ठ","रू","हृ",
            "ङ्ग","त्र","ङ्क","ङ्ख","ट्ठ","द्व",
            "ट्र","ठ्र","ड्र","ढ्र",

            "्य","्र",

            "ड़","ढ़",

            "क्","क","ख्","ख","ग्","ग","घ्","घ", "ङ",
            "च्","च","छ","ज्","ज","झ्","झ","ञ्", "ञ",

            "ट","ठ","ड","ढ","ण्",
            "त्","त","थ्","थ","द","ध्","ध","न्","न",

            "प्","प","फ्","ब्","ब","भ्","भ","म्","म",
            "य","र","ल्","ल","व्","व","श्","श","ष्","स्","स","ह्","ह",

            "ऑ","ऑ","औ","ओ","आ","अ","ई","इ","ऊ","उ","ऋ","ऐ","ए",

            "ॉ","ू","ु","ं","ा","ृ","्","े","ै","ँ","ी","ः",

            "","े","ै","ओ","आ","औ","ओ","ो","ॉ","ो",
            "ुं","े","अ‍ै","ो","अ‍े","ां","अ‍ॅ","ौ","ौ","ृं",
            "ाँ","ूँ","ो","ें"

    };     // Remove typing mistakes in the original file

//  ")","=", ";", "’","!","%",".","�?","+","(","?",".")       // Punctuation marks

    public String convert_to_unicode(String preeti) {


        //  ")","=", ";", "’","!","%",".","�?","+","(","?",".")       // Punctuation marks

        //**************************************************************************************
        // The following two characters are to be replaced through proper checking of locations:
        //**************************************************************************************
        //  "l",
        //  "ि",
        //
        // "{"
        // "र�?" (reph)
        //**************************************************************************************

        int array_one_length = array_one.length;
        String unicodeText = "";
        //****************************************************************************************
        //  Break the long text into small bunches of max. max_text_size  characters each.
        //****************************************************************************************
        int text_size = preeti.length();

        String processed_text = ""; //blank

        //**********************************************
        //    alert("text size = "+text_size);
        //**********************************************

        int sthiti1 = 0;
        int sthiti2 = 0;
        int chale_chalo = 1;

        int max_text_size = 6000;

        while (chale_chalo == 1) {
            sthiti1 = sthiti2;

            if (sthiti2 < (text_size - max_text_size)) {
                sthiti2 += max_text_size;
                while (preeti.charAt(sthiti2) != ' ') {
                    sthiti2--;
                }
            } else {
                sthiti2 = text_size;
                chale_chalo = 0;
            }

            //   alert(" sthiti 1 = "+sthiti1); alert(" sthit 2 = "+sthiti2)

            String modified_substring = preeti.substring(sthiti1, sthiti2);

            modified_substring = Replace_Symbols(modified_substring);

            processed_text += modified_substring;
        }
        return processed_text;
    }

    // --------------------------------------------------


    private String Replace_Symbols(String modified_substring)

    {

        //substitute array_two elements in place of corresponding array_one elements

        if (modified_substring != "") // if stringto be converted is non-blank then no need of any processing.
        {
            for (int input_symbol_idx = 0; input_symbol_idx < array_one.length; input_symbol_idx++)

            {
//                System.out.println(input_symbol_idx + " :: " + array_one[input_symbol_idx] + " :: " + array_two[input_symbol_idx] + " :: " + array_one.length);

                //  alert(" modified substring = "+modified_substring)

                //***********************************************************
                // if (input_symbol_idx==106)
                //  { alert(" input_symbol_idx = "+input_symbol_idx);
                //    alert(" input_symbol_idx = "+input_symbol_idx)
                //; alert(" character =" + modified_substring.CharCodeAt(input_symbol_idx))
                //     alert(" character = "+modified_string.fromCharCode(input_symbol_idx))
                //   }
                // if (input_symbol_idx == 107)
                //   { alert(" input_symbol_idx = "+input_symbol_idx);
                //    alert(" character = ",+string.fromCharCode(input_symbol_idx))
                //   }
                //***********************************************************
                int idx = 0; // index of the symbol being searched for replacement

                while (idx != -1) //while-00
                {

                    modified_substring = modified_substring.replace(array_one[input_symbol_idx], array_two[input_symbol_idx]);
                    idx = modified_substring.indexOf(array_one[input_symbol_idx]);

                } // end of while-00 loop
                // alert(" end of while loop")
            } // end of for loop
            // alert(" end of for loop")

            // alert(" modified substring2 = "+modified_substring)
            //*******************************************************
            int position_of_i = modified_substring.indexOf("l");

            while (position_of_i != -1) //while-02
            {
                char charecter_next_to_i = modified_substring.charAt(position_of_i + 1);
                String charecter_to_be_replaced = "l" + charecter_next_to_i;
                modified_substring = modified_substring.replace(charecter_to_be_replaced, charecter_next_to_i + "ि");
                position_of_i = modified_substring.indexOf("l", position_of_i + 1); // search for i ahead of the current position.

            } // end of while-02 loop

            //**********************************************************************************
            // End of Code for Replacing four Special glyphs
            //**********************************************************************************

            // following loop to eliminate 'chhotee ee kee maatraa' on half-letters as a result of above transformation.

            int position_of_wrong_ee = modified_substring.indexOf("ि्");

            while (position_of_wrong_ee != -1) //while-03

            {
                char consonent_next_to_wrong_ee = modified_substring.charAt(position_of_wrong_ee + 2);
                String charecter_to_be_replaced = "ि्" + consonent_next_to_wrong_ee;
                modified_substring = modified_substring.replace(charecter_to_be_replaced, "�?" + consonent_next_to_wrong_ee + "ि");
                position_of_wrong_ee = modified_substring.indexOf("ि्", position_of_wrong_ee + 2); // search for 'wrong ee' ahead of the current position.

            } // end of while-03 loop

            // following loop to eliminate 'chhotee ee kee maatraa' on half-letters as a result of above transformation.

            position_of_wrong_ee = modified_substring.indexOf("िं्");

            while (position_of_wrong_ee != -1) //while-03

            {
                char consonent_next_to_wrong_ee = modified_substring.charAt(position_of_wrong_ee + 3);
                String charecter_to_be_replaced = "िं्" + consonent_next_to_wrong_ee;
                modified_substring = modified_substring.replace(charecter_to_be_replaced, "�?" + consonent_next_to_wrong_ee + "िं");
                position_of_wrong_ee = modified_substring.indexOf("िं्", position_of_wrong_ee + 3); // search for 'wrong ee' ahead of the current position.

            } // end of while-03 loop


            // Eliminating reph "Ô" and putting 'half - r' at proper position for this.
            String set_of_matras = "ा ि ी ु ू ृ े ै ो ौ ं : ँ ॅ";
            int position_of_R = modified_substring.indexOf("{");

            while (position_of_R > 0) // while-04
            {
                int probable_position_of_half_r = position_of_R - 1;
                char charecter_at_probable_position_of_half_r = modified_substring.charAt(probable_position_of_half_r);


                // trying to find non-maatra position left to current O (ie, half -r).

                while (set_of_matras.contains(charecter_at_probable_position_of_half_r + "")) // while-05

                {
                    probable_position_of_half_r = probable_position_of_half_r - 1;
                    charecter_at_probable_position_of_half_r = modified_substring.charAt(probable_position_of_half_r);

                } // end of while-05

//                System.out.println(probable_position_of_half_r + " :: " + position_of_R + " :: " + (position_of_R - probable_position_of_half_r));
                String charecter_to_be_replaced = modified_substring.substring(probable_position_of_half_r, probable_position_of_half_r+(position_of_R - probable_position_of_half_r));
                String new_replacement_string = "र्" + charecter_to_be_replaced;
                charecter_to_be_replaced = charecter_to_be_replaced + "{";
                modified_substring = modified_substring.replace(charecter_to_be_replaced, new_replacement_string);
                position_of_R = modified_substring.indexOf("{");

            } // end of while-04

            // global conversion of punctuation marks
            //    "=","_","Ö","Ù","‘","Ú","Û","Ü","æ","Æ","±","-","<",
            //    ".",")","=", ";","…", "’","!","%","“","�?","+","(","?",

            modified_substring = modified_substring.replace( "=" , "." )   ;
            modified_substring = modified_substring.replace( "_" , ")" )   ;
            modified_substring = modified_substring.replace( "Ö" , "=" )   ;
            modified_substring = modified_substring.replace( "Ù" , ";" )   ;
            modified_substring = modified_substring.replace( "…" , "‘" )   ;
            modified_substring = modified_substring.replace( "Ú" , "’" )   ;
            modified_substring = modified_substring.replace( "Û" , "!" )   ;
            modified_substring = modified_substring.replace( "Ü" , "%" )   ;
            modified_substring = modified_substring.replace( "æ" , "“" )   ;
            modified_substring = modified_substring.replace( "Æ" , "”" )   ;
            modified_substring = modified_substring.replace( "±" , "+" )   ;
            modified_substring = modified_substring.replace( "-" , "(" )   ;
            modified_substring = modified_substring.replace( "<" , "?" )   ;

        } // end of IF  statement  meant to  supress processing of  blank  string.
        return modified_substring;
    }

} // end of legacy_to_unicode function


