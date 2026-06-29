class Solution {
    public boolean isAnagram(String s, String t) {
      int freqp[]= new int[26];
      int freq[]= new int[26];
for(int i=0;i<s.length();i++)
{
    freq[(s.charAt(i)-'a')]++;

}
for(int i=0;i<t.length();i++)
{
    freqp[(t.charAt(i)-'a')]++;

}
for(int i=0;i<26;i++)
{
    if(freq[i]!=freqp[i])
    return false;
}
return true;

    }
}
