import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

/**
 * Created by i81269 on 2/19/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String string = " 2 \n" +
                "efu�! \n" +
                "k|f/lDes \n" +
                "!=  ;+ljwfg d\"n sfg\"g M -!_ of] ;+ljwfg g]kfnsf] d\"n sfg\"g xf] . o; \n" +
                ";+ljwfg;Fu aflemg] sfg\"g aflemPsf] xb;Dd cdfGo x'g]5 . \n" +
                "-@_ o; ;+ljwfgsf] kfngf ug'{ k|To]s JolQmsf] st{Jo x'g]5 . \n" +
                "@= ;fj{ef}d;Qf / /fhsLo;Qf M g]kfnsf] ;fj{ef}d;Qf / /fhsLo;Qf \n" +
                "g]kfnL hgtfdf lglxt /x]sf] 5 . o;sf] k|of]u o; ;+ljwfgdf Joj:yf \n" +
                "eP adf]lhd x'g]5 .  \n" +
                "#=  /fi6� M ax'hftLo, ax'eflifs, ax'wfld{s, ax';f+:s[lts ljz]iftfo'Qm, \n" +
                "ef}uf]lns ljljwtfdf /x]sf ;dfg cfsf+Iff / g]kfnsf] /fli6�o :jtGqtf, \n" +
                "ef}uf]lns cv08tf, /fli6�o lxt tyf ;d[l4k|lt cf:yfjfg /xL Pstfsf] \n" +
                ";\"qdf cfa4 ;a} g]kfnL hgtf ;dli6df /fi6� xf] . \n" +
                "$=  g]kfn /fHo M -!_ g]kfn :jtGq, cljefHo, ;fj{ef}d;Qf;DkGg, \n" +
                "wd{lg/k]If, ;dfj]zL, nf]stGqfTds, ;dfhjfb pGd'v, ;+3Lo \n" +
                "nf]stflGqs u0ftGqfTds /fHo xf] . \n" +
                ":ki6Ls/0f M o; wf/fsf] k|of]hgsf] nflu �wd{lg/k]If� eGgfn] \n" +
                ";gftgb]lv rlncfPsf] wd{ ;+:s[ltsf] ;+/If0f nufot wfld{s, ;f+:s[lts \n" +
                ":jtGqtf ;Demg' k5{ . \n" +
                "-@_ g]kfnsf] If]q b]xfo adf]lhd x'g]5 M� \n" +
                "-s_ of] ;+ljwfg k|f/De x'Fbfsf avtsf] If]q, / \n" +
                "-v_ of] ;+ljwfg k|f/De ePkl5 k|fKt x'g]  If]q . \n" +
                "%=  /fli6�o lxt M -!_ g]kfnsf] :jtGqtf, ;fj{ef}d;Qf, ef}uf]lns cv08tf, \n" +
                "/fli6�otf, :jfwLgtf, :jfledfg, g]kfnLsf] xs lxtsf] /Iff, ;Ldfgfsf] \n" +
                ";'/Iff, cfly{s ;d'Gglt / ;d[l4 g]kfnsf] /fli6�o lxtsf cfwf/e\"t ljifo \n" +
                "x'g]5g\\ . \n" +
                "-@_ /fi6� lxt k|lts\"nsf] cfr/0f / sfo{ ;+3Lo sfg\"g adf]lhd \n" +
                "b08gLo x'g]5 . \n" +
                "^=  /fi6�efiff M g]kfndf af]lng] ;a} dft[efiffx� /fi6�efiff x'g\\ . \n" +
                "&= ;/sf/L sfdsfhsf] efiff M -!_ b]jgfu/L lnlkdf n]lvg] g]kfnL efiff \n" +
                "g]kfnsf] ;/sf/L sfdsfhsf] efiff x'g]5 .  \n" +
                " 3 \n" +
                "-@_ g]kfnL efiffsf cltl/Qm k|b]zn] cf�gf] k|b]zleq ax';+Vos \n" +
                "hgtfn] af]Ng] Ps jf PseGbf a9L cGo /fi6�efiffnfO{ k|b]z sfg\"g \n" +
                "adf]lhd k|b]zsf] ;/sf/L sfdsfhsf] efiff lgwf{/0f ug{ ;Sg]5 . \n" +
                "-#_ efiff ;DaGwL cGo s'/f efiff cfof]usf] l;kmfl/;df g]kfn \n" +
                ";/sf/n] lg0f{o u/] adf]lhd  x'g]5 . \n" +
                "*= /fli6�o em08f M -!_ l;ld|s /+usf] e'OF / uf9f gLnf] /+usf] lsgf/f ePsf] \n" +
                "b'O{ lqsf]0f clnslt hf]l8Psf], dflyNnf] efudf v'k]{ rGb|sf] aLrdf \n" +
                ";f]x|df cf7 sf]0f b]lvg] ;]tf] cfsf/ / tNnf] efudf afx| sf]0fo'Qm ;\"o{sf] \n" +
                ";]tf] cfsf/ c+lst ePsf] em08f g]kfnsf] /fli6�o em08f xf] .  \n" +
                "-@_ g]kfnsf] /fli6�o em08f, /fli6�o em08f agfpg] t/Lsf / \n" +
                "tT;DaGwL cGo ljj/0f cg';\"rL�! df pNn]v eP adf]lhd  x'g]5 . \n" +
                "(= /fli6�o ufg OToflb M -!_ g]kfnsf] /fli6�o ufg cg';\"rL�@ df pNn]v eP \n" +
                "adf]lhd x'g]5 .  \n" +
                "-@_ g]kfnsf] lgzfg 5fk cg';\"rL�# df pNn]v eP adf]lhd  \n" +
                "x'g]5 . \n" +
                "-#_ g]kfnsf] /fli6�o k\"mn nfnLu'/fF;, /fli6�o /+u l;ld|s, /fli6�o \n" +
                "hgfj/ ufO{ / /fli6�o kIfL 8fFkm] x'g]5 .  \n" +
                " \n" +
                " 4 \n" +
                "efu�@ \n" +
                "gful/stf \n" +
                "!)=  gful/stfaf6 jl~rt gul/g] M -!_ s'g} klg g]kfnL gful/snfO{ \n" +
                "gful/stf k|fKt ug]{ xsaf6 jl~rt ul/g] 5}g .  \n" +
                "-@_ g]kfndf k|fb]lzs klxrfg ;lxtsf] Psn ;+3Lo gful/stfsf] \n" +
                "Joj:yf ul/Psf] 5 . \n" +
                "!!=  g]kfnsf] gful/s 7xg{] M -!_ of] ;+ljwfg k|f/De x'Fbfsf avt g]kfnsf] \n" +
                "gful/stf k|fKt u/]sf / o; efu adf]lhd gful/stf k|fKt ug{ of]Uo \n" +
                "JolQmx� g]kfnsf] gful/s x'g]5g\\ . \n" +
                "-@_ of] ;+ljwfg k|f/De x'Fbfsf avt g]kfndf :yfoL a;f]jf; \n" +
                "ePsf] b]xfosf] JolQm j+zhsf] cfwf/df g]kfnsf] gful/s 7xg]{5 M� \n" +
                "-s_ of] ;+ljwfg k|f/De x'g'eGbf cl3 j+zhsf] cfwf/df \n" +
                "g]kfnsf] gful/stf k|fKt u/]sf] JolQm, \n" +
                "-v_ s'g} JolQmsf] hGd x'Fbfsf avt lghsf] afa' jf cfdf \n" +
                "g]kfnsf] gful/s /x]5 eg] To:tf] JolQm . \n" +
                "-#_ of] ;+ljwfg k|f/De x'g'eGbf cl3 hGdsf] cfwf/df g]kfnsf] \n" +
                "gful/stf k|fKt u/]sf] gful/ssf] ;Gtfgn] afa' / cfdf b'j} g]kfnsf] \n" +
                "gful/s /x]5g\\ eg] lgh aflnu ePkl5 j+zhsf] cfwf/df g]kfnsf] \n" +
                "gful/stf k|fKt ug]{5 . \n" +
                "-$_ g]kfnleq k]mnf k/]sf] lkt[Tj / dft[Tjsf] 7]ufg gePsf] \n" +
                "k|To]s gfafns lghsf] afa' jf cfdf k]mnf gk/];Dd j+zhsf] cfwf/df \n" +
                "g]kfnsf] gful/s 7xg]{5 . \n" +
                "-%_ g]kfnsf] gful/s cfdfaf6 g]kfndf hGd eO{ g]kfndf g} \n" +
                "a;f]af; u/]sf] / afa'sf] klxrfg x'g g;s]sf] JolQmnfO{ j+zhsf] \n" +
                "cfwf/df g]kfnsf] gful/stf k|bfg   ul/g]5 . \n" +
                "t/ afa' ljb]zL gful/s ePsf] 7x/]df To:tf] JolQmsf] gful/stf \n" +
                ";+3Lo sfg\"g adf]lhd c+uLs[t gful/stfdf kl/0ft x'g]5 . \n" +
                "-^_ g]kfnL gful/s;Fu j}jflxs ;DaGw sfod u/]sL ljb]zL \n" +
                "dlxnfn] rfx]df ;+3Lo sfg\"g adf]lhd g]kfnsf] c+uLs[t gful/stf lng \n" +
                ";Sg]5 . \n";

        PreetyToUnicode p = new PreetyToUnicode();
        System.out.println(p.convert_to_unicode(string));
        System.out.println("end");
    }
}
