class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result=new ArrayList<>();
        for(int HH=0;HH<12;HH++){
            for(int MM=0;MM<60;MM++){
                if(Integer.bitCount(HH)+Integer.bitCount(MM)==turnedOn){
                    String hour=String.valueOf(HH);
                    //to add leading zero if minute<10
                    String minute=(MM <10 ? "0" : "") + MM;
                    result.add(hour + ":" + minute);
                }
            }
        }
        return result;
    }
}


       