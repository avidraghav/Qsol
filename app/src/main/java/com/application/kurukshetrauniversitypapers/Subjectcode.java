package com.application.kurukshetrauniversitypapers;

public class Subjectcode {
   static String subjectname;
   static String code;

    public Subjectcode(){}
    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }
    public String getcode() {
        GlobalClass globalClass=new GlobalClass();
        if(globalClass.getBoard().equals("KU")) {

            if (subjectname.equals("Applied chemistry")) {
                code = "AC";
            }
            if (subjectname.equals("Applied mathematics")) {
                code = "AM";
            }
            if (subjectname.equals("Applied physics")) {
                code = "AP";
            }
            if (subjectname.equals("Biology")) {
                code = "BI";
            }
            if (subjectname.equals("Biotechnology")) {
                code = "BT";
            }
            if (subjectname.equals("Calculus and linear algebra")) {

                code = "CU";
            }

            if (subjectname.equals("Chemistry")) {
                code = "CH";
            }

            if (subjectname.equals("Electrical engineering")) {
                code = "EE";
            }
            if (subjectname.equals("Electrical technology")) {
                code = "ET";
            }
            if (subjectname.equals("Engineering drawing")) {
                code = "ED";
            }
            if (subjectname.equals("English")) {
                code = "EH";
            }
            if (subjectname.equals("Fundamentals of computer programming")) {
                code = "FP";
            }
            if (subjectname.equals("Mathematics")) {
                code = "MA";
            }
            if (subjectname.equals("Multivariable calculus and linear algebra")) {
                code = "ML";
            }
            if (subjectname.equals("Physics")) {
                code = "PH";
            }
            if (subjectname.equals("Programming for problem solving")) {
                code = "PP";
            }
            if (subjectname.equals("Semiconductor physics")) {
                code = "SH";
            }
            if (subjectname.equals("Calculus and ordinary differential equation")) {
                code = "CL";
            }
            if (subjectname.equals("Electrical technology fundamentals")) {
                code = "EF";
            }
            if (subjectname.equals("Probability and statistics")) {
                code = "PS";
            }

            if (subjectname.equals("Discrete structure")) {
                code = "DC";
            }
            if (subjectname.equals("Database management system")) {
                code = "DM";
            }
            if (subjectname.equals("Data structures and algorithms")) {
                code = "DT";
            }
            if (subjectname.equals("Data structures")) {

                code = "DS";
            }
            if (subjectname.equals("Digital electronics")) {
                code = "DE";
            }

            if (subjectname.equals("Internet Fundamental")) {
                code = "IF";
            }
            if (subjectname.equals("Programming language")) {

                code = "PL";
            }
            if (subjectname.equals("Mathematics 3")) {

                code = "M3";
            }
            if (subjectname.equals("Object oriented programming")) {


                code = "OP";
            }

            if (subjectname.equals("Computer architecture and organisation")) {
                code = "CA";

            }
            if (subjectname.equals("Microprocessor and interfacing")) {

                code = "MI";
            }
            if (subjectname.equals("Digital data communication")) {

                code = "DD";
            }

            if (subjectname.equals("Operating systems")) {


                code = "OS";
            }
            if (subjectname.equals("Formal Language and automata theory")) {

                code = "AT";
            }
            if (subjectname.equals("Computer networks")) {


                code = "CN";
            }
            if (subjectname.equals("Computer organisation and architecture")) {


                code = "CO";


            }
            if (subjectname.equals("Design and analysis of algorithm")) {


                code = "DA";


            }
            if (subjectname.equals("Simulation and modelling")) {

                code = "SA";
            }
            if (subjectname.equals("Essentials of information technology")) {
                code = "EO";

            }
            if (subjectname.equals("Advanced database systems")) {

                code = "AD";
            }

            if (subjectname.equals("Computer hardware technologies")) {

                code = "CT";
            }
            if (subjectname.equals("Mobile computing")) {

                code = "MC";
            }
            if (subjectname.equals("Network management and security")) {

                code = "NM";
            }
            if (subjectname.equals("Software engineering")) {

                code = "SE";
            }
            if (subjectname.equals("Compiler design")) {

                code = "CD";

            }
            if (subjectname.equals("Web engineering")) {

                code = "WE";

            }

            if (subjectname.equals("Computer graphics and animation")) {

                code = "CG";
            }
            if (subjectname.equals("Cryptography and information security")) {

                code = "CI";

            }
            if (subjectname.equals("Expert systems")) {

                code = "ES";
            }
            if (subjectname.equals("Security and cryptography")) {

                code = "SC";
            }
            if (subjectname.equals("Software project management")) {

                code = "SP";
            }
            if (subjectname.equals("Statistical models for computer science")) {

                code = "SM";
            }
            if (subjectname.equals("Unix and Linux prog")) {

                code = "UL";
            }

            if (subjectname.equals("Cloud computing")) {

                code = "CC";
            }
            if (subjectname.equals("Data warehouse and data mining")) {
                code = "DW";


            }
            if (subjectname.equals("Interactive computer graphics")) {

                code = "IC";
            }
            if (subjectname.equals("Mobile apps development")) {

                code = "MD";
            }
            if (subjectname.equals("Neural network and fuzzy lose")) {

                code = "NO";
            }
            if (subjectname.equals("Neural network and fuzzy logic")) {
                code = "NL";
            }
            if (subjectname.equals("Software testing")) {

                code = "ST";
            }
            if (subjectname.equals("Software verification validation and testing")) {

                code = "SV";
            }
            //ECE SUBJECTS

            if (subjectname.equals("Analog Electronics")) {

                code = "AN";
            }
            if (subjectname.equals("Electromagnetic theory")) {

                code = "EY";
            }
            if (subjectname.equals("Electronic measurements and instruments")) {
                code = "EM";

            }
            if (subjectname.equals("Field and waves")) {

                code = "FW";
            }
            if (subjectname.equals("Transducer and their applications")) {
                code = "TA";

            }
            if (subjectname.equals("Computer communication network")) {

                code = "CE";
            }
            if (subjectname.equals("Control system engineering")) {

                code = "CS";
            }
            if (subjectname.equals("Digital communication")) {

                code = "DO";
            }
            if (subjectname.equals("Digital design using verilog")) {

                code = "DI";
            }
            if (subjectname.equals("Digital signal processing")) {
                code = "DP";

            }
            if (subjectname.equals("Vhdl and digital systems")) {

                code = "VD";
            }
            if (subjectname.equals("Optical communication")) {
                code = "OC";
            }
            if (subjectname.equals("Reliability")) {

                code = "RE";
            }
            if (subjectname.equals("Television engineering")) {
                code = "TE";
            }
            if (subjectname.equals("Artificial intelligence and expert systems")) {
                code = "AI";
            }
            if (subjectname.equals("Microwave engineering")) {

                code = "ME";
            }
            if (subjectname.equals("VLSI design")) {
                code = "VL";
            }

            if (subjectname.equals("Embedded system design")) {

                code = "EI";
            }
            if (subjectname.equals("Radar engineering")) {

                code = "RA";
            }
            if (subjectname.equals("Multimedia communication")) {

                code = "MU";
            }
            if (subjectname.equals("Wireless and mobile communication")) {

                code = "WI";
            }
            //IT SUBJECTS
            if (subjectname.equals("Fundamentals of up interfacing")) {

                code = "FI";
            }
            if (subjectname.equals("Computer graphics")) {

                code = "CM";
            }
            if (subjectname.equals("Management information system")) {

                code = "MM";
            }
            if (subjectname.equals("Introduction to microcontroller")) {

                code = "IM";
            }
            if (subjectname.equals("Artificial intelligence")) {
                code = "AL";
            }
            if (subjectname.equals("Broadband communication")) {
                code = "BC";
            }
            if (subjectname.equals("E commerce")) {
                code = "EC";
            }
            if (subjectname.equals("Linux for security applications")) {
                code = "LS";
            }
            if (subjectname.equals("Advance computer network and applications")) {
                code = "AA";
            }
            if (subjectname.equals("Mobile communication")) {

                code = "MB";
            }
            if (subjectname.equals("Information technology applications")) {

                code = "IO";
            }
            // ELE subjects
            if (subjectname.equals("Communication system")) {
                code = "CY";
            }
            if (subjectname.equals("Electromechanical energy conversion")) {
                code = "EK";
            }
            if (subjectname.equals("Network analysis and synthesis")) {
                code = "NA";
            }
            if (subjectname.equals("Electrical power generation")) {
                code = "EX";
            }
            if (subjectname.equals("Electrical measurements and measuring instruments")) {
                code = "EJ";
            }
            if (subjectname.equals("Power transmission and distribution")) {
                code = "PO";
            }
            if (subjectname.equals("Electrical engineering material and processes")) {

                code = "EG";
            }
            if (subjectname.equals("Electrical machines")) {
                code = "EA";
            }
            if (subjectname.equals("Power generation and control")) {
                code = "PG";
            }
            if (subjectname.equals("Signals and systems")) {
                code = "SS";
            }

            if (subjectname.equals("Advanced programming")) {

                code = "AE";
            }

            if (subjectname.equals("Electrical drives and traction")) {

                code = "EN";
            }
            if (subjectname.equals("Microcontrollers and applications")) {

                code = "EN";
            }
            if (subjectname.equals("Power electronics")) {

                code = "PE";
            }
            if (subjectname.equals("Power system analysis and protection")) {

                code = "PN";
            }

            if (subjectname.equals("Discrete data non linear control system")) {

                code = "DN";
            }
            if (subjectname.equals("Electrical machine design")) {

                code = "EZ";
            }
            if (subjectname.equals("Non conventional sources of energy and management")) {

                code = "NC";
            }
            if (subjectname.equals("High voltage engineering")) {

                code = "HV";
            }

            if (subjectname.equals("Computer methods in power systems")) {
                code = "CP";
            }
            if (subjectname.equals("Electrical engineering material and processes")) {
                code = "EG";
            }
            if (subjectname.equals("Operational research")) {
                code = "OR";
            }
            if (subjectname.equals("Utilisation of electrical energy")) {
                code = "UT";
            }
            // ME SUBJECTS
            if (subjectname.equals("Dynamics of machine")) {
                code = "DY";
            }
            if (subjectname.equals("Fluid mechanics")) {

                code = "FM";
            }
            if (subjectname.equals("Material science")) {

                code = "MT";
            }
            if (subjectname.equals("Mechanics of solids")) {

                code = "MO";
            }
            if (subjectname.equals("Production technology")) {

                code = "PT";
            }
            if (subjectname.equals("Strength of materials")) {

                code = "SL";
            }
            if (subjectname.equals("Steam generator and power")) {

                code = "SG";
            }
            if (subjectname.equals("Computer aided design and manufacturing")) {

                code = "CF";
            }
            if (subjectname.equals("Machine design")) {

                code = "MN";
            }
            if (subjectname.equals("Mechanical vibrations")) {

                code = "MV";
            }
            if (subjectname.equals("Refrigeration and air conditioning")) {

                code = "RC";
            }
            if (subjectname.equals("Tribology")) {

                code = "TY";
            }
            if (subjectname.equals("Theory of machines")) {

                code = "TM";
            }
            if (subjectname.equals("Optics and waves")) {

                code = "OW";
            }
            if (subjectname.equals("Basics of economics and management")) {

                code = "BF";
            }

            if (subjectname.equals("Tribology and mechanical vibration")) {

                code = "TV";
            }
            if (subjectname.equals("Advanced manufacturing tech")) {

                code = "AF";
            }
            if (subjectname.equals("Automobile engineering ")) {

                code = "AG";
            }
            if (subjectname.equals("Maintenance engineering")) {

                code = "MG";
            }
            if (subjectname.equals("Measurement and control")) {

                code = "MR";
            }
            if (subjectname.equals("Statistical quality control and reliability")) {

                code = "SQ";
            }
            if (subjectname.equals("Entrepreneurship")) {

                code = "EP";
            }

            if (subjectname.equals("Non conventional manufacturing")) {
                code = "NG";
            }
            if (subjectname.equals("Powerplant engineering")) {
                code = "PI";
            }
            // MBA subjects
            if (subjectname.equals("Principles and practices of management")) {
                code = "PD";
            }
            if (subjectname.equals("Business communication")) {
                if(globalClass.getBranch().equals("MB"))
                code = "BN";
                if(globalClass.getBranch().equals("BU"))
                    code = "BU";
            }
            if (subjectname.equals("Business statistics")) {

                code = "BS";
            }
            if (subjectname.equals("Computer applications for business")) {

                code = "CB";
            }
            if (subjectname.equals("Financial accounting")) {

                code = "FA";
            }
            if (subjectname.equals("Financial reporting statement and analysis")) {

                code = "FS";
            }
            if (subjectname.equals("Management processes and organisational behaviour")) {

                code = "MQ";
            }
            if (subjectname.equals("Statistics and analysis of decision making")) {

                code = "SY";
            }
            if (subjectname.equals("Managerial economics")) {

                code = "MN";
            }
            if (subjectname.equals("Business environment")) {

                code = "BE";
            }
            if (subjectname.equals("Business research methodology")) {

                code = "BR";
            }
            if (subjectname.equals("Financial management")) {

                if(globalClass.getBranch().equals("MB"))
                code = "FM";
                else code = "FZ";

            }
            if (subjectname.equals("Human resource management")) {

                code = "HR";
            }
            if (subjectname.equals("Management science")) {

                code = "MH";
            }
            if (subjectname.equals("Marketing management")) {

                code = "MK";
            }
            if (subjectname.equals("Organisational behaviour")) {

                code = "OB";
            }
            if (subjectname.equals("Foreign exchange management")) {

                code = "FX";
            }
            if (subjectname.equals("Corporate finance")) {

                code = "CR";
            }
            if (subjectname.equals("Legal environment")) {

                code = "LE";
            }
            if (subjectname.equals("Production and operations management")) {

                code = "PI";
            }
            if (subjectname.equals("Compensation management")) {

                code = "CV";
            }
            if (subjectname.equals("Entrepreneurship development")) {

                code = "EL";
            }
            if (subjectname.equals("Industrial marketing")) {

                code = "IL";
            }
            if (subjectname.equals("International marketing")) {

                code = "IT";
            }
            if (subjectname.equals("Management of financial services")) {

                code = "MF";
            }
            if (subjectname.equals("Management of training and development")) {

                code = "MO";
            }
            if (subjectname.equals("Marketing communication strategy")) {

                code = "MR";
            }
            if (subjectname.equals("Portfolio management")) {

                code = "PT";
            }
            if (subjectname.equals("Principles of insurance and banking")) {

                code = "PB";
            }
            if (subjectname.equals("Project management")) {

                code = "PJ";
            }
            if (subjectname.equals("Service marketing")) {

                code = "SG";
            }
            if (subjectname.equals("Human resource planning and development")) {

                code = "MX";
            }
            if (subjectname.equals("Financial derivative")) {

                code = "FT";
            }
            if (subjectname.equals("International financial management")) {

                code = "IA";
            }
            if (subjectname.equals("Strategies and systems")) {

                code = "SI";
            }
            if (subjectname.equals("Business legislation")) {

                code = "BL";
            }
            if (subjectname.equals("Legal framework governing human relations")) {

                code = "LF";
            }
            if (subjectname.equals("Manpower development for technological change")) {

                code = "MJ";
            }
            if (subjectname.equals("Organisation change and intervention strategies")) {

                code = "OI";
            }
            if (subjectname.equals("Sales and distribution management")) {

                code = "SD";
            }
            if (subjectname.equals("Strategic management")) {

                code = "SR";
            }
            if (subjectname.equals("Working capital management")) {

                code = "WC";
            }

            if (subjectname.equals("Business accounting")) {

                code = "BA";
            }
            if (subjectname.equals("Analysis of financial statements")) {

                code = "AY";
            }
            if (subjectname.equals("Business mathematics")) {

                code = "BM";
            }
            if (subjectname.equals("Hindi")) {
                code = "HI";
            }
            if (subjectname.equals("Business organisation")) {

                code = "BO";
            }
            if (subjectname.equals("Principles of management")) {

                code = "PM";
            }
            if (subjectname.equals("Computer fundamentals")) {

                code = "CF";
            }
            if (subjectname.equals("Understanding human behaviour")) {

                code = "UH";
            }
            if (subjectname.equals("Fundamentals of DBMS and ORACLE")) {

                code = "FD";
            }
            if (subjectname.equals("Micro business environment")) {

                code = "MT";
            }
            if (subjectname.equals("Management accounting")) {

                code = "MG";
            }
            if (subjectname.equals("Human behaviour at work")) {

                code = "HB";
            }
            if (subjectname.equals("Understanding social behaviour")) {

                code = "US";
            }
            if (subjectname.equals("Business intelligence and entrepreneurship")) {
                code = "BG";
            }

            // BCA subjects
            if (subjectname.equals("Logical organization of computer")) {

                code = "LR";
            }
            if (subjectname.equals("Programming in c")) {

                code = "PC";
            }
            if (subjectname.equals("Windows and pc software")) {

                code = "WR";
            }
            if (subjectname.equals("Advanced programming in c")) {

                code = "AG";
            }
            if (subjectname.equals("Office automation tools")) {

                code = "OA";
            }
            if (subjectname.equals("Personality development")) {

                code = "PY";
            }
            if (subjectname.equals("Structured system analysis and design")) {

                code = "SX";
            }
            if (subjectname.equals("Relational database management system")) {

                code = "RD";
            }
            if (subjectname.equals("Computer and programming fundamentals")) {

                code = "CX";
            }
            // MCA subjects

            if (subjectname.equals("Computer organization")) {

                code = "CZ";
            }
            if (subjectname.equals("Discrete mathematical structures")) {

                code = "DU";
            }
            if (subjectname.equals("Numerical and statistical methods")) {

                code = "NS";
            }
            if (subjectname.equals("Web technology")) {

                code = "WT";
            }
            if (subjectname.equals("System programming")) {

                code = "SO";
            }
            if (subjectname.equals("Principles of programming language")) {

                code = "PF";
            }
            if (subjectname.equals("Computer networks and data communication")) {

                code = "CW";
            }
            if (subjectname.equals("Object oriented design using uml")) {

                code = "OU";
            }
            if (subjectname.equals("Visual programming")) {

                code = "VP";
            }
            if (subjectname.equals("Advanced computer architecture")) {

                code = "AH";
            }
            if (subjectname.equals("Programming in java")) {

                code = "PV";
            }
            if (subjectname.equals("Advanced web technology ")) {

                code = "AW";
            }
            if (subjectname.equals("Computer architecture and parallel processing")) {

                code = "CQ";
            }
            if (subjectname.equals("Linux and shell programming")) {
                code = "LP";
            }
            if (subjectname.equals("Electronic devices")) {

                code = "ER";
            }
            if (subjectname.equals("Semiconductor devices and circuits")) {

                code = "SN";
            }
            if (subjectname.equals("Thermodynamics")) {
                code = "TD";
            }
            if (subjectname.equals("Kinematics of machine")) {
                code = "KM";
            }
            if (subjectname.equals("Basics of economics and management")) {
                code = "BZ";
            }
            if (subjectname.equals("IC engine and gas turbine")) {
                code = "GE";
            }
            if (subjectname.equals("Heat transfer")) {
                code = "HT";
            }
            if (subjectname.equals("Industrial engineering")) {
                code = "IE";
            }
            if (subjectname.equals("Linux operating system")) {
                code = "LI";
            }
            if (subjectname.equals("Introduction to digital data communication")) {
                code = "IU";
            }
            if (subjectname.equals("Multimedia and virtual reality")) {
                code = "MY";
            }
            if (subjectname.equals("Web design")) {
                code = "WD";
            }
            if (subjectname.equals("Network programming")) {
                code = "NN";
            }
            if (subjectname.equals("Java programming")) {
                code = "JP";
            }
            if (subjectname.equals("Fundamentals of management")) {
                code = "FN";
            }
            if (subjectname.equals("Electromagnetic waves")) {
                code = "EW";
            }
            if (subjectname.equals("Information theory and coding")) {
                code = "II";
            }


        }
        if(globalClass.getBoard().equals("HS")){
            if (subjectname.equals("Communication skills"))
            {
            code = "S1";
            }
            if (subjectname.equals("Basic electrical engineering"))
            {
                code = "BL";
            }
            if (subjectname.equals("Applied mathematics-1 "))
            {
                code = "M1";
            }
            if (subjectname.equals("Applied physics-1"))
            {
                code = "P1";
            }
            if (subjectname.equals("Applied chemistry-1"))
            {
                code = "C1";
            }
            if (subjectname.equals("Engineering drawing-1"))
            {
                code = "D1";
            }
            if (subjectname.equals("Communication skills-2"))
            {
                code = "S2";
            }
            if (subjectname.equals("Applied mathematics-2 "))
            {
                code = "M2";
            }
            if (subjectname.equals("Applied physics-2"))
            {
                code = "P2";
            }
            if (subjectname.equals("Applied chemistry-2"))
            {
                code = "C2";
            }
            if (subjectname.equals("Applied mechanics"))
            {
                code = "AM";
            }
            if (subjectname.equals("Engineering drawing-2"))
            {
                code = "D2";
            }
            if (subjectname.equals("Applied mathematics-2"))
            {
                code = "M2";
            }
            if (subjectname.equals("Analog electronics-1"))
            {
                code = "AX";
            }
            if (subjectname.equals("Programming in C"))
            {
                code = "PG";
            }
            if (subjectname.equals("Strength of materials"))
            {
                code = "SM";
            }
            if (subjectname.equals("Thermodynamics"))
            {
                code = "TS";
            }
            if (subjectname.equals("Basics of electrical and electronics engineering"))
            {
                code = "BE";
            }
            if (subjectname.equals("Workshop technology-1"))
            {
                code = "W1";
            }
            if (subjectname.equals("Machine drawing"))
            {
                code = "MD";
            }

            if (subjectname.equals("Materials and metallurgy"))
            {
                code = "MM";
            }
            if (subjectname.equals("Ic engines"))
            {
                code = "IS";
            }
            if (subjectname.equals("Machine design and drawing"))
            {
                code = "MG";
            }
            if (subjectname.equals("Workshop technology-2"))
            {
                code = "W2";
            }
            if (subjectname.equals("Theory of machines"))
            {
                code = "TM";
            }
            if (subjectname.equals("Refrigeration and air conditioning"))
            {
                code = "RC";
            }
            if (subjectname.equals("Cnc machines and automation"))
            {
                code = "CN";
            }
            if (subjectname.equals("Workshop technology-3"))
            {
                code = "W3";
            }
            if (subjectname.equals("Environmental education"))
            {
                code = "EV";
            }
            if (subjectname.equals("Industrial engineering-1"))
            {
                code = "I1";
            }
            if (subjectname.equals("Automobile engineering"))
            {
                code = "AE";
            }
            if (subjectname.equals("Inspection and quality control"))
            {
                code = "IC";
            }
            if (subjectname.equals("Industrial engineering-2"))
            {
                code = "I2";
            }
            if (subjectname.equals("Entrepreneurship development and management"))
            {
                code = "ED";
            }
            if (subjectname.equals("Fluid mechanics"))
            {
                code = "FM";
            }
            if (subjectname.equals("Surveying-1"))
            {
                code = "Y1";
            }
            if (subjectname.equals("Construction materials"))
            {
                code = "CM";
            }
            if (subjectname.equals("Building construction"))
            {
                code = "BC";
            }
            if (subjectname.equals("Civil engineering drawing-1"))
            {
                code = "G1";
            }
            if (subjectname.equals("Structural mechanics"))
            {
                code = "SS";
            }
            if (subjectname.equals("Concrete technology"))
            {
                code = "CT";
            }
            if (subjectname.equals("Water supply and waste water management"))
            {
                code = "WM";
            }
            if (subjectname.equals("Irrigation engineering"))
            {
                code = "IG";
            }
            if (subjectname.equals("Surveying-2"))
            {
                code = "Y2";
            }
            if (subjectname.equals("Rcc design"))
            {
                code = "RD";
            }
            if (subjectname.equals("Street structure design"))
            {
                code = "SD";
            }
            if (subjectname.equals("Highway engineering"))
            {
                code = "HE";
            }
            if (subjectname.equals("Surveying-1"))
            {
                code = "SE";
            }
            if (subjectname.equals("Soil and foundation engineering"))
            {
                code = "SE";
            }
            if (subjectname.equals("Earthquake resistant building construction"))
            {
                code = "EC";
            }
            if (subjectname.equals("Railways bridges and tunnels"))
            {
                code = "RT";
            }
            if (subjectname.equals("Quantity surveying and valuation"))
            {
                code = "QV";
            }
            if (subjectname.equals("Construction management and accounts"))
            {
                code = "CD";
            }
            if (subjectname.equals("Repair and maintenance of building"))
            {
                code = "CB";
            }
            if (subjectname.equals("Prestressed concrete"))
            {
                code = "PC";
            }
            if (subjectname.equals("Electrical and electronics engineering materials"))
            {
                code = "EM";
            }
            if (subjectname.equals("Electrical measurements and measuring instruments"))
            {
                code = "EI";
            }
            if (subjectname.equals("Electronics-1"))
            {
                code = "E1";
            }
            if (subjectname.equals("Electrical engineering design and drawing-1"))
            {
                code = "H1";
            }
            if (subjectname.equals("Computer programming and application-1"))
            {
                code = "N1";
            }
            if (subjectname.equals("Fundamentals of electrical engineering"))
            {
                code = "FE";
            }
            if (subjectname.equals("Railways bridges and tunnels"))
            {
                code = "B1";
            }
            if (subjectname.equals("Railways bridges and tunnels"))
            {
                code = "ES";
            }
            if (subjectname.equals("Electronics-2"))
            {
                code = "E2";
            }
            if (subjectname.equals("Electrical engineering design and drawing-2"))
            {
                code = "H2";
            }
            if (subjectname.equals("Instrumentation"))
            {
                code = "IN";
            }
            if (subjectname.equals("Estimating and costing in electrical engineering-1"))
            {
                code = "K1";
            }
            if (subjectname.equals("Utilization if electrical energy-1"))
            {
                code = "U1";
            }
            if (subjectname.equals("Computer programming and application-2"))
            {
                code = "N2";
            }
            if (subjectname.equals("Digital electronics"))
            {
                code = "DE";
            }
            if (subjectname.equals("Electrical machines-2"))
            {
                code = "B2";
            }
            if (subjectname.equals("Electrical power-1"))
            {
                code = "L1";
            }
            if (subjectname.equals("Industrial electronics and control of drives"))
            {
                code = "EN";
            }
            if (subjectname.equals("Digital electronics and microprocessors"))
            {
                code = "DM";
            }
            if (subjectname.equals("Estimating and costing in electrical engineering-2"))
            {
                code = "K2";
            }
            if (subjectname.equals("Utilization if electrical energy-2"))
            {
                code = "U2";
            }
            if (subjectname.equals("Electrical power-2"))
            {
                code = "L2";
            }
            if (subjectname.equals("Programmable logic controls"))
            {
                code = "PL";
            }
            if (subjectname.equals("Energy management"))
            {
                code = "EY";
            }
            if (subjectname.equals("Optical fibre communication"))
            {
                code = "OC";
            }
            if (subjectname.equals("Operating system"))
            {
                code = "OS";
            }
            if (subjectname.equals("Computer peripherals and interfacing"))
            {
                code = "CI";
            }
            if (subjectname.equals("Data communication"))
            {
                code = "DC";
            }
            if (subjectname.equals("Internet and web designing"))
            {
                code = "IW";
            }
            if (subjectname.equals("Data str. Using C"))
            {
                code = "DS";
            }
            if (subjectname.equals("Computer organization"))
            {
                code = "CO";
            }
            if (subjectname.equals("Data base management system"))
            {
                code = "DB";
            }
            if (subjectname.equals("Oops - c++"))
            {
                code = "OP";
            }
            if (subjectname.equals("Microprocessor and peripherals devices"))
            {
                code = "MP";
            }
            if (subjectname.equals("Computer networks"))
            {
                code = "CW";
            }
            if (subjectname.equals("Software engg."))
            {
                code = "ST";
            }
            if (subjectname.equals("Relational DBMS"))
            {
                code = "RS";
            }
            if (subjectname.equals("Visual basic"))
            {
                code = "VB";
            }
            if (subjectname.equals("PHP"))
            {
                code = "PH";
            }
            if (subjectname.equals("Network security"))
            {
                code = "NS";
            }
            if (subjectname.equals("Distributed computing"))
            {
                code = "DG";
            }
            if (subjectname.equals("Programming in Java"))
            {
                code = "PJ";
            }
            if (subjectname.equals("Principles of communication engineering"))
            {
                code = "PZ";
            }
            if (subjectname.equals("Analog electronics"))
            {
                code = "AS";
            }
            if (subjectname.equals("Network filters and transmission lines"))
            {
                code = "NL";
            }
            if (subjectname.equals("Communication systems"))
            {
                code = "CS";
            }
            if (subjectname.equals("Digital electronics-2"))
            {
                code = "T2";
            }
            if (subjectname.equals("Consumer electronics"))
            {
                code = "CE";
            }
            if (subjectname.equals("Microwave and radar engineering"))
            {
                code = "MR";
            }
            if (subjectname.equals("Power electronics"))
            {
                code = "PE";
            }
            if (subjectname.equals("Maintenance of computer systems"))
            {
                code = "MC";
            }
            if (subjectname.equals("Wireless and mobile communication"))
            {
                code = "WC";
            }
            if (subjectname.equals("Medical electronics"))
            {
                code = "ME";
            }
            if (subjectname.equals("Basic chemistry"))
            {
                code = "BY";
            }
            if (subjectname.equals("Anatomy and physiology-1"))
            {
                code = "A1";
            }
            if (subjectname.equals("Clinical microbiology-1"))
            {
                code = "R1";
            }
            if (subjectname.equals("Haematology-1"))
            {
                code = "O1";
            }
            if (subjectname.equals("Clinical biochemistry-1"))
            {
                code = "Z1";
            }
            if (subjectname.equals("Organic chemistry"))
            {
                code = "OY";
            }
            if (subjectname.equals("Anatomy and physiology-2"))
            {
                code = "A2";
            }
            if (subjectname.equals("Clinical microbiology-2"))
            {
                code = "R2";
            }
            if (subjectname.equals("Haematology-2"))
            {
                code = "O2";
            }
            if (subjectname.equals("Clinical biochemistry-2"))
            {
                code = "Z2";
            }
            if (subjectname.equals("Haematology-3"))
            {
                code = "O3";
            }
            if (subjectname.equals("Clinical biochemistry-3"))
            {
                code = "Z3";
            }
            if (subjectname.equals("Histopathology and cytology-1"))
            {
                code = "X1";
            }
            if (subjectname.equals("Transfusion medicine"))
            {
                code = "TN";
            }
            if (subjectname.equals("Clinical microbiology-4"))
            {
                code = "R4";
            }
            if (subjectname.equals("Haematology-4"))
            {
                code = "O4";
            }
            if (subjectname.equals("Histopathology and cytology-2"))
            {
                code = "X2";
            }
            if (subjectname.equals("Medical lab management"))
            {
                code = "MN";
            }


        }
        return code;
    }

}
