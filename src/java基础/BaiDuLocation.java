package java基础;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 日期 : 2021/12/20.
 * 创建 : xin.li
 * 描述 :
 */
class BaiDuLocation {
    static String bdCountryCode = "Afghanistan;\"阿富汗\";\"70069\"\n" +
            "Aland;\"奥兰\";\"180000\"\n" +
            "Albania;\"阿尔巴尼亚\";\"49454\"\n" +
            "Algeria;\"阿尔及利亚\";\"70053\"\n" +
            "American Samoa;\"美属萨摩亚\";\"240000\"\n" +
            "Andorra;\"安道尔\";\"70002\"\n" +
            "Angola;\"安哥拉\";\"70082\"\n" +
            "Anguilla;\"安圭拉\";\"54020\"\n" +
            "Antigua and Barbuda;\"安提瓜和巴布达\";\"54001\"\n" +
            "Argentina;\"阿根廷\";\"39874\"\n" +
            "Armenia;\"亚美尼亚\";\"70021\"\n" +
            "Aruba;\"阿鲁巴\";\"54016\"\n" +
            "Australia;\"澳大利亚\";\"31000\"\n" +
            "Austria;\"奥地利\";\"50147\"\n" +
            "Azerbaijan;\"阿塞拜疆\";\"70024\"\n" +
            "Bahamas;\"巴哈马\";\"390000\"\n" +
            "Bahrain;\"巴林\";\"70067\"\n" +
            "Bangladesh;\"孟加拉国\";\"70013\"\n" +
            "Barbados;\"巴巴多斯\";\"54037\"\n" +
            "Belarus;\"白俄罗斯\";\"70033\"\n" +
            "Belgium;\"比利时\";\"50292\"\n" +
            "Belize;\"伯利兹\";\"54027\"\n" +
            "Benin;\"贝宁\";\"70077\"\n" +
            "Bermuda;\"百慕大\";\"54024\"\n" +
            "Bhutan;\"不丹\";\"70001\"\n" +
            "Bolivia;\"玻利维亚\";\"40717\"\n" +
            "Bonaire, Sint Eustatius and Saba;\"博内尔、圣尤斯特歇斯和沙巴\";\"340000\"\n" +
            "Bosnia and Herzegovina;\"波黑\";\"70018\"\n" +
            "Botswana;\"博茨瓦纳\";\"70036\"\n" +
            "Bouvet Island;\"布韦岛\";\"500000\"\n" +
            "Brazil;\"巴西\";\"39797\"\n" +
            "British Indian Ocean Territory;\"英属印度洋领地\";\"1170000\"\n" +
            "British Sovereign Base Areas;\"英属基地区\";\"52709\"\n" +
            "British Virgin Islands;\"英属维尔京群岛\";\"54009\"\n" +
            "Brunei;\"文莱\";\"31020\"\n" +
            "Bulgaria;\"保加利亚\";\"48180\"\n" +
            "Burkina Faso;\"布基纳法索\";\"70047\"\n" +
            "Burundi;\"布隆迪\";\"70040\"\n" +
            "Cabo Verde;\"佛得角\";\"70057\"\n" +
            "Cambodia;\"柬埔寨\";\"70011\"\n" +
            "Cameroon;\"喀麦隆\";\"70080\"\n" +
            "Canada;\"加拿大\";\"54015\"\n" +
            "Cayman Islands;\"开曼群岛\";\"54038\"\n" +
            "Central African Republic;\"中非共和国\";\"70050\"\n" +
            "Chad;\"乍得\";\"70048\"\n" +
            "Chile;\"智利\";\"40228\"\n" +
            "China;\"中国\";\"0\"\n" +
            "Christmas Island;\"圣诞岛\";\"680000\"\n" +
            "Cocos Islands;\"科科斯群岛\";\"540000\"\n" +
            "Colombia;\"哥伦比亚\";\"40382\"\n" +
            "Comoros;\"科摩罗\";\"70092\"\n" +
            "Cook Islands;\"库克群岛\";\"610000\"\n" +
            "Costa Rica;\"哥斯达黎加\";\"54019\"\n" +
            "Croatia;\"克罗地亚\";\"47999\"\n" +
            "CtedIvoire;\"科特迪瓦\";\"70074\"\n" +
            "Cuba;\"古巴\";\"54039\"\n" +
            "Curasao;\"库拉索\";\"54000\"\n" +
            "Cyprus;\"塞浦路斯\";\"70032\"\n" +
            "Cyprus UN Neutral Zone;\"塞浦路斯联合国中立区\";\"49596\"\n" +
            "Czech Republic;\"捷克共和国\";\"46609\"\n" +
            "Democratic Republic of the Congo;\"刚果民主共和国\";\"70081\"\n" +
            "Denmark;\"丹麦\";\"51828\"\n" +
            "Djibouti;\"吉布提\";\"70103\"\n" +
            "Dominica;\"多米尼克\";\"54005\"\n" +
            "Dominican Republic;\"多米尼加共和国\";\"54004\"\n" +
            "East Timor;\"东帝汶\";\"70009\"\n" +
            "Ecuador;\"厄瓜多尔\";\"39509\"\n" +
            "Egypt;\"埃及\";\"70102\"\n" +
            "El Salvador;\"萨尔瓦多\";\"54006\"\n" +
            "El Salvador;\"萨尔瓦多\";\"54025\"\n" +
            "England;\"英格兰\";\"51441\"\n" +
            "Equatorial Guinea;\"赤道几内亚\";\"70083\"\n" +
            "Eritrea;\"厄立特里亚\";\"70104\"\n" +
            "Estonia;\"爱沙尼亚\";\"47934\"\n" +
            "Ethiopia;\"埃塞俄比亚\";\"70049\"\n" +
            "Falkland Islands;\"福克兰群岛\";\"870000\"\n" +
            "Faroe Islands;\"法罗群岛\";\"890000\"\n" +
            "Fiji;\"斐济\";\"70008\"\n" +
            "Finland;\"芬兰\";\"51372\"\n" +
            "France;\"法国\";\"49841\"\n" +
            "French Guiana;\"法属圭亚那\";\"40024\"\n" +
            "French Polynesia;\"塔希提\";\"70007\"\n" +
            "French Southern Territories;\"法属南部领地\";\"260000\"\n" +
            "Gabon;\"加蓬\";\"70084\"\n" +
            "Gambia;\"冈比亚\";\"70058\"\n" +
            "Gaza Strip;\"加沙地带\";\"44504\"\n" +
            "Georgia;\"格鲁吉亚\";\"70028\"\n" +
            "Germany;\"德国\";\"50664\"\n" +
            "Ghana;\"加纳\";\"70075\"\n" +
            "Gibraltar;\"直布罗陀\";\"70003\"\n" +
            "Greece;\"希腊\";\"46873\"\n" +
            "Greenland;\"格陵兰（丹）\";\"51820\"\n" +
            "Grenada;\"格林纳达\";\"54012\"\n" +
            "Guadeloupe;\"瓜德罗普\";\"54017\"\n" +
            "Guam;\"关岛\";\"1070000\"\n" +
            "Guatemala;\"危地马拉\";\"54008\"\n" +
            "Guernsey;\"根西岛\";\"940000\"\n" +
            "Guinea;\"几内亚\";\"70061\"\n" +
            "Guinea-Bissau;\"几内亚比绍\";\"70060\"\n" +
            "Guyana;\"圭亚那\";\"40540\"\n" +
            "Haiti;\"海地\";\"54029\"\n" +
            "Heard Island and McDonald Islands;\"赫德岛和麦克唐纳群岛\";\"1090000\"\n" +
            "Honduras;\"洪都拉斯\";\"54002\"\n" +
            "Hungary;\"匈牙利\";\"46974\"\n" +
            "Iceland;\"冰岛\";\"52448\"\n" +
            "India;\"印度\";\"31080\"\n" +
            "Indonesia;\"印度尼西亚\";\"31030\"\n" +
            "Iran;\"伊朗\";\"70071\"\n" +
            "Iraq;\"伊拉克\";\"70066\"\n" +
            "Ireland;\"爱尔兰\";\"52012\"\n" +
            "Isle of Man;\"马恩岛\";\"52233\"\n" +
            "Israel;\"以色列\";\"70063\"\n" +
            "Italy;\"意大利\";\"49987\"\n" +
            "Jamaica;\"牙买加\";\"54013\"\n" +
            "Japan;\"日本\";\"26000\"\n" +
            "Jersey;\"泽西岛\";\"1250000\"\n" +
            "Jordan;\"约旦\";\"70062\"\n" +
            "Kazakhstan;\"哈萨克斯坦\";\"70023\"\n" +
            "Kenya;\"肯尼亚\";\"70096\"\n" +
            "Kiribati;\"基里巴斯\";\"1320000\"\n" +
            "Kosovo;\"科索沃\";\"70030\"\n" +
            "Kuwait;\"科威特\";\"70070\"\n" +
            "Kyrgyzstan;\"吉尔吉斯斯坦\";\"70022\"\n" +
            "Laos;\"老挝\";\"70012\"\n" +
            "Latvia;\"拉脱维亚\";\"47765\"\n" +
            "Lebanon;\"黎巴嫩\";\"70064\"\n" +
            "Lesotho;\"莱索托\";\"70037\"\n" +
            "Liberia;\"利比里亚\";\"70073\"\n" +
            "Libya;\"利比亚\";\"70056\"\n" +
            "Liechtenstein;\"列支敦士登\";\"70004\"\n" +
            "Lithuania;\"立陶宛\";\"70017\"\n" +
            "Luxembourg;\"卢森堡\";\"50353\"\n" +
            "Macedonia;\"马其顿\";\"70029\"\n" +
            "Madagascar;\"马达加斯加\";\"70091\"\n" +
            "Malawi;\"马拉维\";\"70039\"\n" +
            "Malaysia;\"马来西亚\";\"31190\"\n" +
            "Maldives;\"马尔代夫\";\"31180\"\n" +
            "Mali;\"马里\";\"70046\"\n" +
            "Malta;\"马耳他\";\"70006\"\n" +
            "Marshall Islands;\"马绍尔群岛\";\"1540000\"\n" +
            "Martinique;\"马提尼克\";\"54007\"\n" +
            "Mauritania;\"毛里塔尼亚\";\"70055\"\n" +
            "Mauritius;\"毛里求斯\";\"65533\"\n" +
            "Mayotte;\"马约特\";\"70093\"\n" +
            "Mexico;\"墨西哥\";\"54025\"\n" +
            "Micronesia;\"密克罗尼西亚\";\"900000\"\n" +
            "Moldova;\"摩尔多瓦\";\"70019\"\n" +
            "Monaco;\"摩纳哥\";\"51168\"\n" +
            "Mongolia;\"蒙古\";\"70015\"\n" +
            "Montenegro;\"黑山\";\"70020\"\n" +
            "Montserrat;\"蒙特塞拉特\";\"1640000\"\n" +
            "Morocco;\"摩洛哥\";\"70052\"\n" +
            "Mozambique;\"莫桑比克\";\"70088\"\n" +
            "Myanmar;\"缅甸\";\"70014\"\n" +
            "Namibia;\"纳米比亚\";\"70086\"\n" +
            "Nauru;\"瑙鲁\";\"1800000\"\n" +
            "Nepal;\"尼泊尔\";\"31220\"\n" +
            "Netherlands;\"荷兰\";\"52386\"\n" +
            "New Caledonia;\"新喀里多尼亚\";\"1710000\"\n" +
            "New Zealand;\"新西兰\";\"31230\"\n" +
            "Nicaragua;\"尼加拉瓜\";\"54032\"\n" +
            "Niger;\"尼日尔\";\"70045\"\n" +
            "Nigeria;\"尼日利亚\";\"70078\"\n" +
            "Niue;\"纽埃\";\"1760000\"\n" +
            "Norfolk Island;\"诺福克岛\";\"1730000\"\n" +
            "Northern Ireland;\"北爱尔兰\";\"52088\"\n" +
            "Northern Mariana Islands;\"北马里亚纳群岛\";\"1610000\"\n" +
            "North Korea;\"朝鲜\";\"70010\"\n" +
            "Norway;\"挪威\";\"52164\"\n" +
            "Oman;\"阿曼\";\"70099\"\n" +
            "Pakistan;\"巴基斯坦\";\"70035\"\n" +
            "Palau;\"帕劳\";\"1880000\"\n" +
            "Palestina;\"巴勒斯坦\";\"54030\"\n" +
            "Panama;\"巴拿马\";\"54021\"\n" +
            "Papua New Guinea;\"巴布亚新几内亚\";\"1890000\"\n" +
            "Paraguay;\"巴拉圭\";\"40879\"\n" +
            "Peru;\"秘鲁\";\"40465\"\n" +
            "Philippines;\"菲律宾\";\"31260\"\n" +
            "Pitcairn Islands;\"皮特凯恩群岛\";\"1850000\"\n" +
            "Poland;\"波兰\";\"47200\"\n" +
            "Portugal;\"葡萄牙\";\"51933\"\n" +
            "Puerto Rico;\"波多黎各\";\"54028\"\n" +
            "Qatar;\"卡塔尔\";\"70068\"\n" +
            "Republic of the Congo;\"刚果共和国\";\"70085\"\n" +
            "Reunion;\"留尼汪\";\"70089\"\n" +
            "Romania;\"罗马尼亚\";\"48258\"\n" +
            "Russia;\"俄罗斯\";\"70034\"\n" +
            "Rwanda;\"卢旺达\";\"70043\"\n" +
            "Saint Barthelemy;\"圣巴泰勒米\";\"40177\"\n" +
            "Saint Kitts and Nevis;\"圣基茨和尼维斯\";\"54010\"\n" +
            "Saint Lucia;\"圣卢西亚\";\"54035\"\n" +
            "Saint Martin;\"法属圣马丁\";\"1470000\"\n" +
            "Saint Pierre and Miquelon;\"圣皮埃尔和密克隆群岛\";\"54034\"\n" +
            "Saint Vincent and the Grenadines;\"圣文森特和格林纳丁斯\";\"54014\"\n" +
            "Samoa;\"萨摩亚\";\"2530000\"\n" +
            "San Marino;\"圣马力诺\";\"70005\"\n" +
            "Sao Tome and Principe;\"圣多美和普林西比\";\"70079\"\n" +
            "Saudi Arabia;\"沙特阿拉伯\";\"70101\"\n" +
            "Scotland;\"苏格兰\";\"51603\"\n" +
            "Senegal;\"塞内加尔\";\"70059\"\n" +
            "Serbia;\"塞尔维亚\";\"70031\"\n" +
            "Seychelles;\"塞舌尔\";\"70094\"\n" +
            "Sierra Leone;\"塞拉利昂\";\"70072\"\n" +
            "Singapore;\"新加坡\";\"20000\"\n" +
            "Sint Maarten;\"荷属圣马丁\";\"2700000\"\n" +
            "Slovakia;\"斯洛伐克\";\"46751\"\n" +
            "Slovenia;\"斯洛文尼亚\";\"70016\"\n" +
            "Solomon Islands;\"所罗门群岛\";\"2090000\"\n" +
            "Somalia;\"索马里\";\"70097\"\n" +
            "South Africa;\"南非\";\"70087\"\n" +
            "South Georgia and the South Sandwich Islands;\"南乔治亚和南桑威奇群岛\";\"2060000\"\n" +
            "South Korea;\"韩国\";\"30000\"\n" +
            "South Sudan;\"南苏丹\";\"70042\"\n" +
            "Spain;\"西班牙\";\"51270\"\n" +
            "Sri Lanka;\"斯里兰卡\";\"31130\"\n" +
            "St Helena, Ascension, and T. Cunha;\"圣赫勒拿、阿森松和特里斯坦-达库尼亚\";\"42409\"\n" +
            "Sudan;\"苏丹\";\"70105\"\n" +
            "Suriname;\"苏里南\";\"39584\"\n" +
            "Svalbard and Jan Mayen;\"斯瓦尔巴和扬马延\";\"2080000\"\n" +
            "Swaziland;\"斯威士兰\";\"70038\"\n" +
            "Sweden;\"瑞典\";\"51757\"\n" +
            "Switzerland;\"瑞士\";\"50466\"\n" +
            "Syria;\"叙利亚\";\"70065\"\n" +
            "Tajikistan;\"塔吉克斯坦\";\"70025\"\n" +
            "Tanzania;\"坦桑尼亚\";\"70095\"\n" +
            "Thailand;\"泰国\";\"20500\"\n" +
            "Togo;\"多哥\";\"70076\"\n" +
            "Tokelau;\"托克劳\";\"2300000\"\n" +
            "Tonga;\"汤加\";\"2330000\"\n" +
            "Trinidad and Tobago;\"特立尼达和多巴哥\";\"54033\"\n" +
            "Tunisia;\"突尼斯\";\"70106\"\n" +
            "Turkey;\"土耳其\";\"48509\"\n" +
            "Turkish Republic of Northern Cyprus;\"北塞浦路斯土耳其共和国\";\"52762\"\n" +
            "Turkmenistan;\"土库曼斯坦\";\"70027\"\n" +
            "Turks and Caicos Islands;\"特克斯和凯科斯群岛\";\"2250000\"\n" +
            "Tuvalu;\"图瓦卢\";\"2370000\"\n" +
            "Uganda;\"乌干达\";\"70041\"\n" +
            "Ukraine;\"乌克兰\";\"49182\"\n" +
            "United Arab Emirates;\"阿联酋\";\"70100\"\n" +
            "United States;\"美国\";\"54003\"\n" +
            "United States Minor Outlying Islands;\"美国本土外小岛屿\";\"54026\"\n" +
            "Uruguay;\"乌拉圭\";\"39644\"\n" +
            "Uzbekistan;\"乌兹别克斯坦\";\"70026\"\n" +
            "Vanuatu;\"瓦努阿图\";\"2510000\"\n" +
            "Vatican;\"梵蒂冈\";\"50415\"\n" +
            "Venezuela;\"委内瑞拉\";\"39949\"\n" +
            "Vietnam;\"越南\";\"32370\"\n" +
            "Virgin Islands;\"美属维尔京群岛\";\"54031\"\n" +
            "Wales;\"威尔士\";\"51685\"\n" +
            "Wallis and Futuna;\"瓦利斯和富图纳\";\"2520000\"\n" +
            "Western Sahara;\"西撒哈拉\";\"70054\"\n" +
            "Yemen;\"也门\";\"70098\"\n" +
            "Zambia;\"赞比亚\";\"70051\"\n" +
            "Zimbabwe;\"津巴布韦\";\"70044\"";

    public static void main1(String[] args) {
        String[] split = countryCode.split("\n");
        for (int i = 0; i < split.length; i++) {
            String countryItem = split[i];
            String[] child = countryItem.split("\t");
            if (child.length >= 4){
                System.out.print("\"" + child[0]+ "\"" + ": " + "\"" + child[3] + "\"," );
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> bdCountry = new HashMap<>();
        String[] bdCodeArray = bdCountryCode.split("\n");
        for (int i = 0; i < bdCodeArray.length; i++) {
            String countryItem = bdCodeArray[i];
            String[] child = countryItem.split(";");

            if (child.length >= 3){
                String num = child[2].replaceAll("\"", "");
                bdCountry.put(num, child[0]);
            }
        }

        // "Aruba\t阿鲁巴\tABW\tAW\n"
        Map<String, String> countryCodeMap = new HashMap<>();
        String[] countryCodeArray = countryCode.split("\n");
        for (int i = 0; i < countryCodeArray.length; i++) {
            String countryItem = countryCodeArray[i];
            String[] child = countryItem.split("\t");
            if (child.length >= 4){
                //System.out.print("\"" + child[0]+ "\"" + ": " + "\"" + child[3] + "\"," );
                countryCodeMap.put(child[0], child[3]);
            }
        }

        String countryName = bdCountry.get("0");
        System.out.println(countryCodeMap.get(countryName));

        System.out.println(bdCountry.size());
        System.out.println(countryCodeMap.size());

        Set<Map.Entry<String, String>> entries = bdCountry.entrySet();
        for (Map.Entry<String, String> item: entries) {
            String key = item.getKey();
            System.out.print("\"" + key + "\"" + ": " + "\"" + countryCodeMap.get(item.getValue()) + "\"," );
        }
    }



    static String countryCode = "Aruba\t阿鲁巴\tABW\tAW\n" +
            "Afghanistan\t阿富汗\tAFG\tAF\n" +
            "Angola\t安哥拉\tAGO\tAO\n" +
            "Anguilla\t安圭拉\tAIA\tAI\n" +
            "Aland\t奥兰\tALA\tAX\n" +
            "Albania\t阿尔巴尼亚\tALB\tAL\n" +
            "Andorra\t安道尔\tAND\tAD\n" +
            "United Arab Emirates\t阿联酋\tARE\tAE\n" +
            "Argentina\t阿根廷\tARG\tAR\n" +
            "Armenia\t亚美尼亚\tARM\tAM\n" +
            "American Samoa\t美属萨摩亚\tASM\tAS\n" +
            "French Southern Territories\t法属南部领地\tATF\tTF\n" +
            "Antigua and Barbuda\t安提瓜和巴布达\tATG\tAG\n" +
            "Australia\t澳大利亚\tAUS\tAU\n" +
            "Austria\t奥地利\tAUT\tAT\n" +
            "Azerbaijan\t阿塞拜疆\tAZE\tAZ\n" +
            "Burundi\t布隆迪\tBDI\tBI\n" +
            "Belgium\t比利时\tBEL\tBE\n" +
            "Benin\t贝宁\tBEN\tBJ\n" +
            "Bonaire, Sint Eustatius and Saba\t博内尔、圣尤斯特歇斯和沙巴\tBES\tBQ\n" +
            "Burkina Faso\t布基纳法索\tBFA\tBF\n" +
            "Bangladesh\t孟加拉国\tBGD\tBD\n" +
            "Bulgaria\t保加利亚\tBGR\tBG\n" +
            "Bahrain\t巴林\tBHR\tBH\n" +
            "Bahamas\t巴哈马\tBHS\tBS\n" +
            "Bosnia and Herzegovina\t波黑\tBIH\tBA\n" +
            "Saint Barthelemy\t圣巴泰勒米\tBLM\tBL\n" +
            "Belarus\t白俄罗斯\tBLR\tBY\n" +
            "Belize\t伯利兹\tBLZ\tBZ\n" +
            "Bermuda\t百慕大\tBMU\tBM\n" +
            "Bolivia\t玻利维亚\tBOL\tBO\n" +
            "Brazil\t巴西\tBRA\tBR\n" +
            "Barbados\t巴巴多斯\tBRB\tBB\n" +
            "Brunei\t文莱\tBRN\tBN\n" +
            "Bhutan\t不丹\tBTN\tBT\n" +
            "Bouvet Island\t布韦岛\tBVT\tBV\n" +
            "Botswana\t博茨瓦纳\tBWA\tBW\n" +
            "Central African Republic\t中非共和国\tCAF\tCF\n" +
            "Canada\t加拿大\tCAN\tCA\n" +
            "Cocos Islands\t科科斯群岛\tCCK\tCC\n" +
            "Switzerland\t瑞士\tCHE\tCH\n" +
            "Chile\t智利\tCHL\tCL\n" +
            "China\t中国\tCHN\tCN\n" +
            "CtedIvoire\t科特迪瓦\tCIV\tCI\n" +
            "Cameroon\t喀麦隆\tCMR\tCM\n" +
            "Democratic Republic of the Congo\t刚果民主共和国\tCOD\tCD\n" +
            "Republic of the Congo\t刚果共和国\tCOG\tCG\n" +
            "Cook Islands\t库克群岛\tCOK\tCK\n" +
            "Colombia\t哥伦比亚\tCOL\tCO\n" +
            "Comoros\t科摩罗\tCOM\tKM\n" +
            "Cabo Verde\t佛得角\tCPV\tCV\n" +
            "Costa Rica\t哥斯达黎加\tCRI\tCR\n" +
            "Cuba\t古巴\tCUB\tCU\n" +
            "Curasao\t库拉索\tCUW\tCW\n" +
            "Christmas Island\t圣诞岛\tCXR\tCX\n" +
            "Cayman Islands\t开曼群岛\tCYM\tKY\n" +
            "Cyprus UN Neutral Zone\t塞浦路斯联合国中立区\tCYP\tCY\n" +
            "Cyprus\t塞浦路斯\tCYP\tCY\n" +
            "Turkish Republic of Northern Cyprus\t北塞浦路斯土耳其共和国\tCYP\tCY\n" +
            "Czech Republic\t捷克共和国\tCZE\tCZ\n" +
            "Germany\t德国\tDEU\tDE\n" +
            "Djibouti\t吉布提\tDJI\tDJ\n" +
            "Dominica\t多米尼克\tDMA\tDM\n" +
            "Denmark\t丹麦\tDNK\tDK\n" +
            "Dominican Republic\t多米尼加共和国\tDOM\tDO\n" +
            "Algeria\t阿尔及利亚\tDZA\tDZ\n" +
            "Ecuador\t厄瓜多尔\tECU\tEC\n" +
            "Egypt\t埃及\tEGY\tEG\n" +
            "Eritrea\t厄立特里亚\tERI\tER\n" +
            "Western Sahara\t西撒哈拉\tESH\tEH\n" +
            "Spain\t西班牙\tESP\tES\n" +
            "Estonia\t爱沙尼亚\tEST\tEE\n" +
            "Ethiopia\t埃塞俄比亚\tETH\tET\n" +
            "Finland\t芬兰\tFIN\tFI\n" +
            "Fiji\t斐济\tFJI\tFJ\n" +
            "Falkland Islands\t福克兰群岛\tFLK\tFK\n" +
            "France\t法国\tFRA\tFR\n" +
            "Faroe Islands\t法罗群岛\tFRO\tFO\n" +
            "Micronesia\t密克罗尼西亚\tFSM\tFM\n" +
            "Gabon\t加蓬\tGAB\tGA\n" +
            "British Sovereign Base Areas\t英属基地区\tGBR\tGB\n" +
            "England\t英格兰\tGBR\tGB\n" +
            "Scotland\t苏格兰\tGBR\tGB\n" +
            "Wales\t威尔士\tGBR\tGB\n" +
            "Northern Ireland\t北爱尔兰\tGBR\tGB\n" +
            "Georgia\t格鲁吉亚\tGEO\tGE\n" +
            "Guernsey\t根西岛\tGGY\tGG\n" +
            "Ghana\t加纳\tGHA\tGH\n" +
            "Gibraltar\t直布罗陀\tGIB\tGI\n" +
            "Guinea\t几内亚\tGIN\tGN\n" +
            "Guadeloupe\t瓜德罗普\tGLP\tGP\n" +
            "Gambia\t冈比亚\tGMB\tGM\n" +
            "Guinea-Bissau\t几内亚比绍\tGNB\tGW\n" +
            "Equatorial Guinea\t赤道几内亚\tGNQ\tGQ\n" +
            "Greece\t希腊\tGRC\tGR\n" +
            "Grenada\t格林纳达\tGRD\tGD\n" +
            "Guatemala\t危地马拉\tGTM\tGT\n" +
            "French Guiana\t法属圭亚那\tGUF\tGF\n" +
            "Guam\t关岛\tGUM\tGU\n" +
            "Guyana\t圭亚那\tGUY\tGY\n" +
            "Heard Island and McDonald Islands\t赫德岛和麦克唐纳群岛\tHMD\tHM\n" +
            "Honduras\t洪都拉斯\tHND\tHN\n" +
            "Croatia\t克罗地亚\tHRV\tHR\n" +
            "Haiti\t海地\tHTI\tHT\n" +
            "Hungary\t匈牙利\tHUN\tHU\n" +
            "Indonesia\t印度尼西亚\tIDN\tID\n" +
            "Isle of Man\t马恩岛\tIMN\tIM\n" +
            "India\t印度\tIND\tIN\n" +
            "British Indian Ocean Territory\t英属印度洋领地\tIOT\tIO\n" +
            "Ireland\t爱尔兰\tIRL\tIE\n" +
            "Iran\t伊朗\tIRN\tIR\n" +
            "Iraq\t伊拉克\tIRQ\tIQ\n" +
            "Iceland\t冰岛\tISL\tIS\n" +
            "Israel\t以色列\tISR\tIL\n" +
            "Italy\t意大利\tITA\tIT\n" +
            "Jamaica\t牙买加\tJAM\tJM\n" +
            "Jersey\t泽西岛\tJEY\tJE\n" +
            "Jordan\t约旦\tJOR\tJO\n" +
            "Japan\t日本\tJPN\tJP\n" +
            "Kazakhstan\t哈萨克斯坦\tKAZ\tKZ\n" +
            "Kenya\t肯尼亚\tKEN\tKE\n" +
            "Kyrgyzstan\t吉尔吉斯斯坦\tKGZ\tKG\n" +
            "Cambodia\t柬埔寨\tKHM\tKH\n" +
            "Kiribati\t基里巴斯\tKIR\tKI\n" +
            "Saint Kitts and Nevis\t圣基茨和尼维斯\tKNA\tKN\n" +
            "South Korea\t韩国\tKOR\tKR\n" +
            "Kuwait\t科威特\tKWT\tKW\n" +
            "Laos\t老挝\tLAO\tLA\n" +
            "Lebanon\t黎巴嫩\tLBN\tLB\n" +
            "Liberia\t利比里亚\tLBR\tLR\n" +
            "Libya\t利比亚\tLBY\tLY\n" +
            "Saint Lucia\t圣卢西亚\tLCA\tLC\n" +
            "Liechtenstein\t列支敦士登\tLIE\tLI\n" +
            "Sri Lanka\t斯里兰卡\tLKA\tLK\n" +
            "Lesotho\t莱索托\tLSO\tLS\n" +
            "Lithuania\t立陶宛\tLTU\tLT\n" +
            "Luxembourg\t卢森堡\tLUX\tLU\n" +
            "Latvia\t拉脱维亚\tLVA\tLV\n" +
            "Saint Martin\t法属圣马丁\tMAF\tMF\n" +
            "Morocco\t摩洛哥\tMAR\tMA\n" +
            "Monaco\t摩纳哥\tMCO\tMC\n" +
            "Moldova\t摩尔多瓦\tMDA\tMD\n" +
            "Madagascar\t马达加斯加\tMDG\tMG\n" +
            "Maldives\t马尔代夫\tMDV\tMV\n" +
            "Mexico\t墨西哥\tMEX\tMX\n" +
            "Marshall Islands\t马绍尔群岛\tMHL\tMH\n" +
            "Macedonia\t马其顿\tMKD\tMK\n" +
            "Mali\t马里\tMLI\tML\n" +
            "Malta\t马耳他\tMLT\tMT\n" +
            "Myanmar\t缅甸\tMMR\tMM\n" +
            "Montenegro\t黑山\tMNE\tME\n" +
            "Mongolia\t蒙古\tMNG\tMN\n" +
            "Northern Mariana Islands\t北马里亚纳群岛\tMNP\tMP\n" +
            "Mozambique\t莫桑比克\tMOZ\tMZ\n" +
            "Mauritania\t毛里塔尼亚\tMRT\tMR\n" +
            "Montserrat\t蒙特塞拉特\tMSR\tMS\n" +
            "Martinique\t马提尼克\tMTQ\tMQ\n" +
            "Mauritius\t毛里求斯\tMUS\tMU\n" +
            "Malawi\t马拉维\tMWI\tMW\n" +
            "Malaysia\t马来西亚\tMYS\tMY\n" +
            "Mayotte\t马约特\tMYT\tYT\n" +
            "Namibia\t纳米比亚\tNAM\tNA\n" +
            "New Caledonia\t新喀里多尼亚\tNCL\tNC\n" +
            "Niger\t尼日尔\tNER\tNE\n" +
            "Norfolk Island\t诺福克岛\tNFK\tNF\n" +
            "Nigeria\t尼日利亚\tNGA\tNG\n" +
            "Nicaragua\t尼加拉瓜\tNIC\tNI\n" +
            "Niue\t纽埃\tNIU\tNU\n" +
            "Netherlands\t荷兰\tNLD\tNL\n" +
            "Norway\t挪威\tNOR\tNO\n" +
            "Nepal\t尼泊尔\tNPL\tNP\n" +
            "Nauru\t瑙鲁\tNRU\tNR\n" +
            "New Zealand\t新西兰\tNZL\tNZ\n" +
            "Oman\t阿曼\tOMN\tOM\n" +
            "Pakistan\t巴基斯坦\tPAK\tPK\n" +
            "Panama\t巴拿马\tPAN\tPA\n" +
            "Pitcairn Islands\t皮特凯恩群岛\tPCN\tPN\n" +
            "Peru\t秘鲁\tPER\tPE\n" +
            "Philippines\t菲律宾\tPHL\tPH\n" +
            "Palau\t帕劳\tPLW\tPW\n" +
            "Papua New Guinea\t巴布亚新几内亚\tPNG\tPG\n" +
            "Poland\t波兰\tPOL\tPL\n" +
            "Puerto Rico\t波多黎各\tPRI\tPR\n" +
            "North Korea\t朝鲜\tPRK\tKP\n" +
            "Portugal\t葡萄牙\tPRT\tPT\n" +
            "Paraguay\t巴拉圭\tPRY\tPY\n" +
            "Palestina\t巴勒斯坦\tPSE\tPS\n" +
            "French Polynesia\t塔希提\tPYF\tPF\n" +
            "Qatar\t卡塔尔\tQAT\tQA\n" +
            "Reunion\t留尼汪\tREU\tRE\n" +
            "Romania\t罗马尼亚\tROU\tRO\n" +
            "Russia\t俄罗斯\tRUS\tRU\n" +
            "Rwanda\t卢旺达\tRWA\tRW\n" +
            "Saudi Arabia\t沙特阿拉伯\tSAU\tSA\n" +
            "Sudan\t苏丹\tSDN\tSD\n" +
            "Senegal\t塞内加尔\tSEN\tSN\n" +
            "Singapore\t新加坡\tSGP\tSG\n" +
            "South Georgia and the South Sandwich Islands\t南乔治亚和南桑威奇群岛\tSGS\tGS\n" +
            "St Helena, Ascension, and T. Cunha\t圣赫勒拿、阿森松和特里斯坦-达库尼亚\tSHN\tSH\n" +
            "Svalbard and Jan Mayen\t斯瓦尔巴和扬马延\tSJM\tSJ\n" +
            "Solomon Islands\t所罗门群岛\tSLB\tSB\n" +
            "Sierra Leone\t塞拉利昂\tSLE\tSL\n" +
            "El Salvador\t萨尔瓦多\tSLV\tSV\n" +
            "San Marino\t圣马力诺\tSMR\tSM\n" +
            "Somalia\t索马里\tSOM\tSO\n" +
            "Saint Pierre and Miquelon\t圣皮埃尔和密克隆群岛\tSPM\tPM\n" +
            "Serbia\t塞尔维亚\tSRB\tRS\n" +
            "South Sudan\t南苏丹\tSSD\tSS\n" +
            "Sao Tome and Principe\t圣多美和普林西比\tSTP\tST\n" +
            "Suriname\t苏里南\tSUR\tSR\n" +
            "Slovakia\t斯洛伐克\tSVK\tSK\n" +
            "Slovenia\t斯洛文尼亚\tSVN\tSI\n" +
            "Sweden\t瑞典\tSWE\tSE\n" +
            "Swaziland\t斯威士兰\tSWZ\tSZ\n" +
            "Sint Maarten\t荷属圣马丁\tSXM\tSX\n" +
            "Seychelles\t塞舌尔\tSYC\tSC\n" +
            "Syria\t叙利亚\tSYR\tSY\n" +
            "Turks and Caicos Islands\t特克斯和凯科斯群岛\tTCA\tTC\n" +
            "Chad\t乍得\tTCD\tTD\n" +
            "Togo\t多哥\tTGO\tTG\n" +
            "Thailand\t泰国\tTHA\tTH\n" +
            "Tajikistan\t塔吉克斯坦\tTJK\tTJ\n" +
            "Tokelau\t托克劳\tTKL\tTK\n" +
            "Turkmenistan\t土库曼斯坦\tTKM\tTM\n" +
            "East Timor\t东帝汶\tTLS\tTL\n" +
            "Tonga\t汤加\tTON\tTO\n" +
            "Trinidad and Tobago\t特立尼达和多巴哥\tTTO\tTT\n" +
            "Tunisia\t突尼斯\tTUN\tTN\n" +
            "Turkey\t土耳其\tTUR\tTR\n" +
            "Tuvalu\t图瓦卢\tTUV\tTV\n" +
            "Tanzania\t坦桑尼亚\tTZA\tTZ\n" +
            "Uganda\t乌干达\tUGA\tUG\n" +
            "Ukraine\t乌克兰\tUKR\tUA\n" +
            "United States Minor Outlying Islands\t美国本土外小岛屿\tUMI\tUM\n" +
            "Uruguay\t乌拉圭\tURY\tUY\n" +
            "United States\t美国\tUSA\tUS\n" +
            "Uzbekistan\t乌兹别克斯坦\tUZB\tUZ\n" +
            "Vatican\t梵蒂冈\tVAT\tVA\n" +
            "Saint Vincent and the Grenadines\t圣文森特和格林纳丁斯\tVCT\tVC\n" +
            "Venezuela\t委内瑞拉\tVEN\tVE\n" +
            "British Virgin Islands\t英属维尔京群岛\tVGB\tVG\n" +
            "Virgin Islands\t美属维尔京群岛\tVIR\tVI\n" +
            "Vietnam\t越南\tVNM\tVN\n" +
            "Vanuatu\t瓦努阿图\tVUT\tVU\n" +
            "Wallis and Futuna\t瓦利斯和富图纳\tWLF\tWF\n" +
            "Samoa\t萨摩亚\tWSM\tWS\n" +
            "Kosovo\t科索沃\tXKS\tXK\n" +
            "Yemen\t也门\tYEM\tYE\n" +
            "South Africa\t南非\tZAF\tZA\n" +
            "Zambia\t赞比亚\tZMB\tZM\n" +
            "Zimbabwe\t津巴布韦\tZWE\tZW\n" +
            "Gaza Strip\t加沙地带\t\t";
}
