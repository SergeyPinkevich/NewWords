package com.mockingbird.spinkevich.newwords.presentation.data.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class TranslateHelper {

    private final static HashMap<String, String> LANGUAGE_MAP;

    static {
        LANGUAGE_MAP = new LinkedHashMap<>();
        LANGUAGE_MAP.put("Azerbaijan", "az");
        LANGUAGE_MAP.put("Afrikaans", "af");
        LANGUAGE_MAP.put("Albanian", "sq");
        LANGUAGE_MAP.put("Amharic", "am");
        LANGUAGE_MAP.put("Arabic", "ar");
        LANGUAGE_MAP.put("Armenian", "hy");
        LANGUAGE_MAP.put("Bashkir", "ba");
        LANGUAGE_MAP.put("Basque", "eu");
        LANGUAGE_MAP.put("Belarusian", "be");
        LANGUAGE_MAP.put("Bengali", "bn");
        LANGUAGE_MAP.put("Bosnian", "bs");
        LANGUAGE_MAP.put("Bulgarian", "bg");
        LANGUAGE_MAP.put("Burmese", "my");
        LANGUAGE_MAP.put("Catalan", "ca");
        LANGUAGE_MAP.put("Cebuano", "ceb");
        LANGUAGE_MAP.put("Chinese", "zh");
        LANGUAGE_MAP.put("Croatian", "hr");
        LANGUAGE_MAP.put("Czech", "cs");
        LANGUAGE_MAP.put("Danish", "da");
        LANGUAGE_MAP.put("Dutch", "nl");
        LANGUAGE_MAP.put("English", "en");
        LANGUAGE_MAP.put("Esperanto", "eo");
        LANGUAGE_MAP.put("Estonian", "et");
        LANGUAGE_MAP.put("Finnish", "fi");
        LANGUAGE_MAP.put("French", "fr");
        LANGUAGE_MAP.put("Galician", "gl");
        LANGUAGE_MAP.put("Georgian", "ka");
        LANGUAGE_MAP.put("German", "de");
        LANGUAGE_MAP.put("Greek", "el");
        LANGUAGE_MAP.put("Gujarati", "gu");
        LANGUAGE_MAP.put("Haitian (Creole)", "ht");
        LANGUAGE_MAP.put("Hebrew", "he");
        LANGUAGE_MAP.put("Hill Mari", "mrj");
        LANGUAGE_MAP.put("Hindi", "hi");
        LANGUAGE_MAP.put("Hungarian", "hu");
        LANGUAGE_MAP.put("Icelandic", "is");
        LANGUAGE_MAP.put("Indonesian", "id");
        LANGUAGE_MAP.put("Irish", "ga");
        LANGUAGE_MAP.put("Italian", "it");
        LANGUAGE_MAP.put("Japanese", "ja");
        LANGUAGE_MAP.put("Javanese", "jv");
        LANGUAGE_MAP.put("Kannada", "kn");
        LANGUAGE_MAP.put("Kazakh", "kk");
        LANGUAGE_MAP.put("Khmer", "km");
        LANGUAGE_MAP.put("Korean", "ko");
        LANGUAGE_MAP.put("Kyrgyz", "ky");
        LANGUAGE_MAP.put("Laotian", "lo");
        LANGUAGE_MAP.put("Latin", "la");
        LANGUAGE_MAP.put("Latvian", "lv");
        LANGUAGE_MAP.put("Lithuanian", "lt");
        LANGUAGE_MAP.put("Luxembourgish", "lb");
        LANGUAGE_MAP.put("Macedonian", "mk");
        LANGUAGE_MAP.put("Malagasy", "mg");
        LANGUAGE_MAP.put("Malay", "ms");
        LANGUAGE_MAP.put("Malayalam", "ml");
        LANGUAGE_MAP.put("Maltese", "mt");
        LANGUAGE_MAP.put("Maori", "mi");
        LANGUAGE_MAP.put("Marathi", "mr");
        LANGUAGE_MAP.put("Mari", "mhr");
        LANGUAGE_MAP.put("Mongolian", "mn");
        LANGUAGE_MAP.put("Nepali", "ne");
        LANGUAGE_MAP.put("Norwegian", "no");
        LANGUAGE_MAP.put("Papiamento", "pap");
        LANGUAGE_MAP.put("Persian", "fa");
        LANGUAGE_MAP.put("Polish", "pl");
        LANGUAGE_MAP.put("Portuguese", "pt");
        LANGUAGE_MAP.put("Punjabi", "pa");
        LANGUAGE_MAP.put("Romanian", "ro");
        LANGUAGE_MAP.put("Russian", "ru");
        LANGUAGE_MAP.put("Scottish", "gd");
        LANGUAGE_MAP.put("Serbian", "sr");
        LANGUAGE_MAP.put("Sinhala", "si");
        LANGUAGE_MAP.put("Slovakian", "sk");
        LANGUAGE_MAP.put("Slovenian", "sl");
        LANGUAGE_MAP.put("Spanish", "es");
        LANGUAGE_MAP.put("Sundanese", "su");
        LANGUAGE_MAP.put("Swahili", "sw");
        LANGUAGE_MAP.put("Swedish", "sv");
        LANGUAGE_MAP.put("Tagalog", "tl");
        LANGUAGE_MAP.put("Tajik", "tg");
        LANGUAGE_MAP.put("Tamil", "ta");
        LANGUAGE_MAP.put("Tatar", "tt");
        LANGUAGE_MAP.put("Telugu", "te");
        LANGUAGE_MAP.put("Thai", "th");
        LANGUAGE_MAP.put("Turkish", "tr");
        LANGUAGE_MAP.put("Udmurt", "udm");
        LANGUAGE_MAP.put("Ukrainian", "uk");
        LANGUAGE_MAP.put("Urdu", "ur");
        LANGUAGE_MAP.put("Uzbek", "uz");
        LANGUAGE_MAP.put("Vietnamese", "vi");
        LANGUAGE_MAP.put("Welsh", "cy");
        LANGUAGE_MAP.put("Xhosa", "xh");
        LANGUAGE_MAP.put("Yiddish", "yi");
    }

    public static String getLanguageCode(String language) {
        return LANGUAGE_MAP.get(language);
    }

    public static List<String> getLanguages() {
        return new ArrayList<>(LANGUAGE_MAP.keySet());
    }
}
