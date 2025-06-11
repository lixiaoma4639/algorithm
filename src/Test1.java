import 数据结构.List;
import 数据结构.stack.list.ArrayList1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * 日期 : 2021/7/19.
 * 创建 : xin.li
 * 描述 :
 */
class Test1 {


    public static final String STATE_UP_DETAIL = "Reservation:Upcoming Detail Page for Upcoming";
    public static final String STATE_UP_DETAIL_IN_HOUSE = "Reservation:Upcoming Detail Page for In-house";


    public static void main(String[] args) {
        try (
                BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
                BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"))
        ) {
            // 读取文件内容
            System.out.println(br1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main5(String[] args) {
        String result = "A";
        byte aa = 1;
        String thisThing = String.format("%02x", aa);
        result = result.concat(thisThing);
        System.out.println(result);
    }

    public static void main3(String[] args) {
        System.out.println("1 & 4 = " + (1 & 4));
        System.out.println("2 & 4 = " + (2 & 4));
        System.out.println("4 & 4 = " + (4 & 4));
        System.out.println("5 & 4 = " + (5 & 4));
        System.out.println("6 & 4 = " + (6 & 4));
    }

    public static void main2(String[] args) {
//        String limit2 = "can {0}F{1} before local time hh:mm, 24 Jun 2024";
//        int cancelLimitIndex0 = limit2.indexOf("{0}");
//        int cancelLimitIndex1 = limit2.indexOf("{1}");
//        System.out.println(cancelLimitIndex0);
//        System.out.println(cancelLimitIndex1);
//        limit2 = limit2.replaceAll("\\{\\d}", "" );
//        System.out.println(limit2);
//        System.out.println(limit2.substring(cancelLimitIndex0 , cancelLimitIndex1 - 3));

//        String event = String.format("Click_%s_%s", STATE_UP_DETAIL_IN_HOUSE, "GREEN_STAY");
//        System.out.println(event);

//        long sc = 1000;
//        System.out.println(Math.ceil(570 * sc / 60000f) );
//        DetailedDidNotUnlockReason guestCardOverridden = DetailedDidNotUnlockReason.GuestCardOverridden;
//        System.out.println(guestCardOverridden.value);
//
//        System.out.println(0x01);
//
//        List<String> aaa = new ArrayList1<>();
//        System.out.println(aaa.get(0));

//        String[]  aaa = new String[3];

        Object aaa = null;
        System.out.println(aaa instanceof Boolean);
        System.out.println((boolean) aaa);
    }

    public enum DetailedDidNotUnlockReason {

        // 0x40 - Key is overridden
        GuestCardOverridden (0x0010),
        GuestCardOverridden_v2 (0x0011),

        // 0x41 - Key is not valid yet
        CardNotValidYet (0x0012),

        // 0x42 - Key has expired
        CardHasExpired (0x0142),

        // 0x43 - Key is cancelled
        CardCancelled (0x0017),

        // 0x44 - Key group is blocked
        CardUsergroupBlocked (0x0018),

        // 0x45 - Key has no access to this room
        NoAccessToThisRoom (0x0140),

        // 0x46 - Key has no access to this hotel
        WrongSystemNumberOnCard (0x0105),

        // 0x47 - Key not valid at this time of day
        NotValidAtThisTime (0x0016),
        CardOnlyValidDuringOpeningTime (0x0020),

        // 0x48 - Key blocked because of deadbolt
        DoorUnitDeadBolted (0x0021),
        DoorUnitDeadBoltedGuest (0x0022),
        DoorUnitDeadBoltedFamily (0x0023),

        // 0x49 - Key blocked because of room privacy settings
        NotValidDueToPrivacyStatus (0x0026),
        NotValidDueToPrivacyStatusSilt (0x0027),
        NotValidDutToDoNotDisturbStatus (0x002b),

        // 0x4a - Key blocked because of door battery level
        AccessDeniedDueToBatteryAlarm (0x0035),

        // 0x4b - Key blocked by anti passback function
        NotValidDueToAntiPassback (0x0015),

        // 0x4c - Key refused because door is not locked
        NotValidDueToDoorNotClosed (0x0024),
        NotValidDueToOpenStatus (0x0025),

        // 0x4d - Key refused due to PIN code
        WrongPIN (0x0013),
        WrongPIN_v2 (0x0019),

        // 0x4e - Key blocked by access rules
        CommandNotValidForThisLock (0x001a),
        CounterValueTooLow (0x0014),
        NotValidDueToPassageRevoked (0x0028),

        NotApplicable (-1);

        private final int value;
        DetailedDidNotUnlockReason(int value) {
            this.value = value;
        }

        public static DetailedDidNotUnlockReason fromInt(int id) {
            DetailedDidNotUnlockReason foundValue = NotApplicable;
            for (DetailedDidNotUnlockReason type : DetailedDidNotUnlockReason.values()) {
                if (type.value == id ) {
                    foundValue = type;
                    break;
                }
            }
            return foundValue;
        }
    }
}
