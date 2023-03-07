package com.brigido.bomba.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
import static java.util.Arrays.*;

@Getter
@AllArgsConstructor
public enum WhosOnFirstWords {

    PRONTO("SIM", "OK", "O QUÊ?", "MEIO", "ESQUERDA", "APERTA", "CERTO", "ASSENTO", "PRONTO", "NÃO", "PRIMEIRO", "HMMMMM", "NADA", "ACENTO"),
    PRIMEIRO("ESQUERDA", "OK", "SIM", "MEIO", "NÃO", "CERTO", "NADA", "HMMMMM", "ACENTO", "PRONTO", "ASSENTO", "O QUÊ?", "APERTA", "PRIMEIRO"),
    NAO("ASSENTO", "HMMMMM", "ACENTO", "PRIMEIRO", "O QUÊ?", "PRONTO", "CERTO", "SIM", "NADA", "ESQUERDA", "APERTA", "OK", "NÃO", "MEIO"),
    ASSENTO("ACENTO", "CERTO", "OK", "MEIO", "ASSENTO", "APERTA", "PRONTO", "NADA", "NÃO", "O QUÊ?", "ESQUERDA", "HMMMMM", "SIM", "PRIMEIRO"),
    NADA("HMMMMM", "CERTO", "OK", "MEIO", "SIM", "ASSENTO", "NÃO", "APERTA", "ESQUERDA", "O QUÊ?", "ACENTO", "PRIMEIRO", "NADA", "PRONTO"),
    SIM("OK", "CERTO", "HMMMMM", "MEIO", "PRIMEIRO", "O QUÊ?", "APERTA", "PRONTO", "NADA", "SIM", "ESQUERDA", "ASSENTO", "NÃO", "ACENTO"),
    O_QUE("HMMMMM", "O QUÊ?", "ESQUERDA", "NADA", "PRONTO", "ASSENTO", "MEIO", "NÃO", "OK", "PRIMEIRO", "ACENTO", "SIM", "APERTA", "CERTO"),
    HMMMMM("PRONTO", "NADA", "ESQUERDA", "O QUÊ?", "OK", "SIM", "CERTO", "NÃO", "APERTA", "ASSENTO", "HMMMMM", "MEIO", "ACENTO", "PRIMEIRO"),
    ESQUERDA("CERTO", "ESQUERDA", "PRIMEIRO", "NÃO", "MEIO", "SIM", "ASSENTO", "O QUÊ?", "HMMMMM", "ACENTO", "APERTA", "PRONTO", "OK", "NADA"),
    CERTO("SIM", "NADA", "PRONTO", "APERTA", "NÃO", "ACENTO", "O QUÊ?", "CERTO", "MEIO", "ESQUERDA", "HMMMMM", "ASSENTO", "OK", "PRIMEIRO"),
    MEIO("ASSENTO", "PRONTO", "OK", "O QUÊ?", "NADA", "APERTA", "NÃO", "ACENTO", "ESQUERDA", "MEIO", "CERTO", "PRIMEIRO", "HMMMMM", "SIM"),
    OK("MEIO", "NÃO", "PRIMEIRO", "SIM", "HMMMMM", "NADA", "ACENTO", "OK", "ESQUERDA", "PRONTO", "ASSENTO", "APERTA", "O QUÊ?", "CERTO"),
    ACENTO("HMMMMM", "NÃO", "ASSENTO", "OK", "SIM", "ESQUERDA", "PRIMEIRO", "APERTA", "O QUÊ?", "ACENTO", "NADA", "PRONTO", "CERTO", "MEIO"),
    APERTA("CERTO", "MEIO", "SIM", "PRONTO", "APERTA", "OK", "NADA", "HMMMMM", "ASSENTO", "ESQUERDA", "PRIMEIRO", "O QUÊ?", "NÃO", "ACENTO"),
    VOCE("CLARO", "VOCÊ É", "OCÊ", "CÊ É", "PRÓXIMO", "AHÃ", "C É", "CENSO", "QUÊ?", "VOCÊ", "NÃO SEI", "SENSO", "BORA", "REPETE"),
    VOCE_E("OCÊ", "PRÓXIMO", "SENSO", "AHÃ", "QUÊ?", "BORA", "NÃO SEI", "CENSO", "VOCÊ", "REPETE", "CÊ É", "CLARO", "C É", "VOCÊ É"),
    OCE("NÃO SEI", "VOCÊ É", "AHÃ", "OCÊ", "PRÓXIMO", "C É", "CLARO", "REPETE", "CÊ É", "VOCÊ", "QUÊ?", "CENSO", "SENSO", "BORA"),
    CE_E("VOCÊ", "CÊ É", "C É", "PRÓXIMO", "NÃO SEI", "VOCÊ É", "REPETE", "OCÊ", "QUÊ?", "AHÃ", "CLARO", "BORA", "SENSO", "CENSO"),
    C_E("BORA", "REPETE", "C É", "AHÃ", "QUÊ?", "CLARO", "OCÊ", "CENSO", "CÊ É", "SENSO", "PRÓXIMO", "NÃO SEI", "VOCÊ É", "VOCÊ"),
    REPETE("AHÃ", "CLARO", "PRÓXIMO", "QUÊ?", "CÊ É", "C É", "NÃO SEI", "BORA", "REPETE", "VOCÊ", "SENSO", "CENSO", "VOCÊ É", "OCÊ"),
    AHA("AHÃ", "OCÊ", "VOCÊ É", "VOCÊ", "BORA", "CENSO", "NÃO SEI", "PRÓXIMO", "CLARO", "SENSO", "CÊ É", "C É", "REPETE", "QUÊ?"),
    NAO_SEI("C É", "REPETE", "VOCÊ É", "CÊ É", "PRÓXIMO", "NÃO SEI", "BORA", "VOCÊ", "AHÃ", "SENSO", "OCÊ", "CLARO", "CENSO", "QUÊ?"),
    QUE("VOCÊ", "CENSO", "CÊ É", "OCÊ", "REPETE", "BORA", "NÃO SEI", "SENSO", "VOCÊ É", "AHÃ", "C É", "PRÓXIMO", "QUÊ?", "CLARO"),
    BORA("CLARO", "AHÃ", "PRÓXIMO", "QUÊ?", "OCÊ", "C É", "CÊ É", "CENSO", "SENSO", "VOCÊ", "REPETE", "VOCÊ É", "NÃO SEI", "BORA"),
    PROXIMO("QUÊ?", "AHÃ", "NÃO SEI", "OCÊ", "CENSO", "CLARO", "PRÓXIMO", "SENSO", "BORA", "VOCÊ É", "C É", "CÊ É", "REPETE", "VOCÊ"),
    CENSO("VOCÊ É", "REPETE", "BORA", "NÃO SEI", "VOCÊ", "C É", "CLARO", "QUÊ?", "CÊ É", "PRÓXIMO", "CENSO", "AHÃ", "OCÊ", "SENSO"),
    CLARO("VOCÊ É", "BORA", "SENSO", "CÊ É", "VOCÊ", "CENSO", "AHÃ", "C É", "CLARO", "REPETE", "QUÊ?", "PRÓXIMO", "OCÊ", "NÃO SEI"),
    SENSO("CÊ É", "PRÓXIMO", "REPETE", "C É", "CENSO", "BORA", "NÃO SEI", "QUÊ?", "AHÃ", "VOCÊ", "SENSO", "CLARO", "VOCÊ É", "OCÊ");


    private final String word, word2, word3, word4, word5, word6, word7, word8, word9, word10, word11, word12, word13, word14;

    private List<String> getWords() {
        return asList(word, word2, word3, word4, word5, word6, word7, word8, word9, word10, word11, word12, word13, word14);
    }

    public static String getSelectedWord(String buttonWord, List<String> words) {
        WhosOnFirstWords whosOnFirstWords = WhosOnFirstWords.valueOf(buttonWord);
        for (String word : words) {
            if (whosOnFirstWords.getWords().contains(word)) {
                return word;
            }
        }
        return "";
    }
}
