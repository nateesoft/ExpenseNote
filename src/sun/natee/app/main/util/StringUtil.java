package sun.natee.app.main.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StringUtil {

    private static final SimpleDateFormat dateFmtyyyyMMdd_db = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private static final SimpleDateFormat dateFmtdd_MM_yyyy = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat dateFmtyyyy = new SimpleDateFormat("yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat dateFmtMM = new SimpleDateFormat("MM", Locale.ENGLISH);
    private static final SimpleDateFormat dd_MM_yyyy_HH_mm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
    private static final SimpleDateFormat dateFmtEEEE = new SimpleDateFormat("EEEE", Locale.ENGLISH);
    private static final SimpleDateFormat dateFmtEE = new SimpleDateFormat("EE", Locale.ENGLISH);
    private static final SimpleDateFormat dateFmtdd = new SimpleDateFormat("dd", Locale.ENGLISH);
    private static final SimpleDateFormat dateFmttimeHHmm = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
    private static final SimpleDateFormat dateFmttimeHHmmss = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
    private static final DecimalFormat decNormalFmt = new DecimalFormat("#,##0.00");
    private static final DecimalFormat decNoPointFmt = new DecimalFormat("#,##0");
    private static final DecimalFormat doublePointFmt = new DecimalFormat("0.00");

    public static String trim(String str) {
        if (str == null) {
            return "";
        }
        if (str.trim().equals("")) {
            return "";
        }
        return str;
    }

    public static String bahtFormat(Object str) {
        return decNormalFmt.format(str);
    }

    public static String intFormat(Object str) {
        return decNoPointFmt.format(str);
    }

    public static boolean isEmpty(String str) {
        return trim(str).isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !trim(str).isEmpty();
    }

    public static BigDecimal strToBig(String str) {
        str = str.replace(",", "");
        return new BigDecimal(str);
    }

    public static int strToInt(String str) {
        str = str.replace(",", "");
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }

        return 0;
    }

    public static double strToDouble(String str) {
        str = str.replace(",", "");
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
        }

        return 0;
    }

    public static Date strToDate(String str) {
        try {
            Date date = dateFmtdd_MM_yyyy.parse(str);
            return date;
        } catch (ParseException e) {
        }
        return new Date();
    }

    public static Date strToDateTime(String str) {
        try {
            Date date = dd_MM_yyyy_HH_mm.parse(str);
            return date;
        } catch (ParseException e) {
        }
        return new Date();
    }

    public static String dateToDb(Date date) {
        return dateFmtyyyyMMdd_db.format(date);
    }

    public static String dateStr(Date time) {
        return dateFmtdd_MM_yyyy.format(time);
    }

    public static String dayStr(Date time) {
        return dateFmtEEEE.format(time);
    }
    
    public static String dateToEE(Date time) {
        return dateFmtEE.format(time);
    }

    public static String yearStr(Date time) {
        return dateFmtyyyy.format(time);
    }

    public static String monthStr(Date time) {
        return dateFmtMM.format(time);
    }

    public static String ddStr(Date time) {
        return dateFmtdd.format(time);
    }

    public static String timeStr(Date time) {
        return dateFmttimeHHmm.format(time);
    }

    public static int getMaxMonth(Date time) {
        Calendar car = Calendar.getInstance(Locale.ENGLISH);
        car.setTime(time);

        int maxMonth = car.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxMonth;
    }

    public static boolean isMaxMonth(Date time) {
        Calendar car = Calendar.getInstance(Locale.ENGLISH);
        car.setTime(time);
        int maxMonth = car.getActualMaximum(Calendar.DAY_OF_MONTH);
        car.set(Calendar.DATE, maxMonth);

        String dateStr1 = dateStr(time);
        String dateStr2 = dateStr(car.getTime());
        return dateStr1.equals(dateStr2);
    }

    public static boolean isStartMonth(Date time) {
        return ddStr(time).equals("01");
    }

    public static String showSystem() {
        return dd_MM_yyyy_HH_mm.format(new Date());
    }

    public static String toFormatStr(String str, Object... param) {
        MessageFormat mf = new MessageFormat(str);
        return mf.format(param);
    }

    public static boolean objNotNull(Object obj) {
        return obj != null;
    }
    
    public static boolean objNull(Object obj) {
        return obj != null;
    }

    public static boolean compareFile(String f) {
        File file = new File(f);
        int dayInt;
        switch (dateFmtEE.format(file.lastModified())) {
            case "Sun":
                dayInt = 1;
                break;
            case "Mon":
                dayInt = 2;
                break;
            case "Tue":
                dayInt = 3;
                break;
            case "Wed":
                dayInt = 4;
                break;
            case "Thu":
                dayInt = 5;
                break;
            case "Fri":
                dayInt = 6;
                break;
            case "Sat":
                dayInt = 7;
                break;
            default:
                dayInt = -1;
                break;
        }
        String[] time = dateFmtyyyyMMdd_db.format(file.lastModified()).split("-");

        if (file.exists()) {
            BufferedReader br = null;
            FileReader fr = null;
            try {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                String line;
                boolean isValid = false;
                while ((line = br.readLine()) != null) {
                    isValid = Integer.parseInt(line) == (Integer.parseInt(time[0]) + Integer.parseInt(time[1]) + Integer.parseInt(time[2])) * dayInt;
                    if (isValid) {
                        break;
                    }
                }
                return isValid;
            } catch (IOException e) {
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                    if (fr != null) {
                        fr.close();
                    }
                } catch (IOException ex) {
                }
            }
        }

        return false;
    }

    public static boolean isUnlockSoftware(String str) {
        int dayInt;
        String EE = dateFmtEE.format(new Date());
        switch (EE) {
            case "Sun":
                dayInt = 1;
                break;
            case "Mon":
                dayInt = 2;
                break;
            case "Tue":
                dayInt = 3;
                break;
            case "Wed":
                dayInt = 4;
                break;
            case "Thu":
                dayInt = 5;
                break;
            case "Fri":
                dayInt = 6;
                break;
            case "Sat":
                dayInt = 7;
                break;
            default:
                dayInt = -1;
                break;
        }
        String[] time = dateFmtyyyyMMdd_db.format(new Date()).split("-");
        boolean isValid = Integer.parseInt(str) == (Integer.parseInt(time[0]) + Integer.parseInt(time[1]) + Integer.parseInt(time[2])) * dayInt;
        if (isValid) {
            BufferedWriter bw = null;
            FileWriter fw = null;
            try {
                String content = "" + (Integer.parseInt(time[0]) + Integer.parseInt(time[1]) + Integer.parseInt(time[2])) * dayInt;
                fw = new FileWriter("app.reg");
                bw = new BufferedWriter(fw);
                bw.write(content);
                bw.flush();
            } catch (IOException e) {
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException ex) {
                }

            }
        }
        return isValid;
    }

    public static String doubleFmt(Object obj) {
        return doublePointFmt.format(obj);
    }

    public static String getCurrentDate() {
        return dateFmtdd_MM_yyyy.format(new Date());
    }

    public static String getCurrentTime() {
        return dateFmttimeHHmmss.format(new Date());
    }

}
