package StringPProblem;

public class RabinKarp {
	public static int matchString(String A, String B){
		int n = A.length();
		int m = B.length();
		int prime = 29;
		int mod = (int)1e9 + 7;
		long pow[] = new long[n];
		pow[0] = 1;
		for(int i=1; i<n; i++) {
			pow[i] = (pow[i-1]*prime)%mod;
		}
		long hash[] = new long[n+1];
		hash[0] = 0;
		for(int i=0; i<n; i++) {
			hash[i+1] = (hash[i]+ (A.charAt(i)-'a'+1)*pow[i])%mod;
		}
		long hashOfB = 0;
		for(int i=0; i<m; i++) {
			hashOfB = (hashOfB + (B.charAt(i)-'a'+1)*pow[i])%mod;
		}
		int ans=0;
		for(int i=0; i+m-1<n; i++) {
			long currHash = (hash[i+m]+mod - hash[i])%mod;
			if(currHash == (hashOfB*pow[i])%mod) {
				ans++;
			}
		}
		return ans;
	}
	public static void main(String args[]) {
		String A = "acbac";
		String B = "ac";
		System.out.println(matchString(A, B));
	}
}
