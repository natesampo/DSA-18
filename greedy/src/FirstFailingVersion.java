package greedy.src;

public class FirstFailingVersion {

	public static long recurse(long n, long start, long middle, long end, IsFailingVersion isBadVersion) {
    	if (isBadVersion.isFailingVersion(start)) {
    		return start;
    	}
    	if (isBadVersion.isFailingVersion(middle)) {
    		return recurse(n, start, (start+middle-1)/2,middle-1, isBadVersion);
    	}
    	else if (!isBadVersion.isFailingVersion(middle)) {
    		return recurse(n,middle+1,start+end/2, n, isBadVersion);
    	}
    	return -1;
    }

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
    	return recurse(n,0,n/2, n, isBadVersion);
    }
}