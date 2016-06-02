import java.util.*;

class Video{
	String videoId;
	int nbrOfHits;
	public Video(String vId){
		this.videoId = vId;
	}
	public Video(String vId, int hits){
		this.videoId = vId;
		this.nbrOfHits = hits;
	}
	public void setVideoId(String vId){
		this.videoId = vId;
	}
	public String getVideoId(){
		return this.videoId;
	}
	public int getNbrOfHits(){
		return this.nbrOfHits;
	}
	public void setNbrOfHits(int hits){
		this.nbrOfHits = hits;
	}
	public void incNbrOfHits(){
		this.nbrOfHits++;
	}
}

class VideoComparator implements Comparator<Video>{

	public int compare(Video v1, Video v2) {

		if(v1.getNbrOfHits() < v2.getNbrOfHits())
			return 1;
		else if(v1.getNbrOfHits() > v2.getNbrOfHits())
			return -1;
		else
			return 0;
	}

}

public class Ashutosh {

	static HashMap<String, Video> videoMap = new HashMap<String, Video>();
	static HashMap<String, Integer> rankingMap = new HashMap<String, Integer>();
	static PriorityQueue<Video> pq = new PriorityQueue<Video>(new VideoComparator());

	public static void main(String[] args) {

		runExecution();
	}

	public static void runExecution()
	{
		// 6 of this
		videoViewed("Batman vs Superman");
		videoViewed("Batman vs Superman");
		videoViewed("Batman vs Superman");
		videoViewed("Batman vs Superman");
		videoViewed("Batman vs Superman");
		videoViewed("Batman vs Superman");
		// 5 of this 
		videoViewed("the great gatsby");
		videoViewed("the great gatsby");
		videoViewed("the great gatsby");
		videoViewed("the great gatsby");
		videoViewed("the great gatsby");
		// 4 of this 
		videoViewed("Rain man");
		videoViewed("Rain man");
		videoViewed("Rain man");
		videoViewed("Rain man");
		// 3 of this
		videoViewed("Matrix");
		videoViewed("Matrix");
		videoViewed("Matrix");
		// 2 of this 
		videoViewed("Spiderman");
		videoViewed("Spiderman");
		// 1 of this 
		videoViewed("Her");
		videoViewed("Who am I");
		videoViewed("King's Speech");
		videoViewed("What a day");
		videoViewed("Mission impossible");
		videoViewed("Gone girl");
		System.out.println("------------test for getRanking--------------------");
		System.out.println("<<Batman vs Superman>>, the rank should be ---> 1");
		System.out.println(getRanking("Batman vs Superman"));
		System.out.println("<<Rain man>>, the rank should be ---> 3");
		System.out.println(getRanking("Rain man"));
		System.out.println("<<Spiderman>>, the rank should be ---> 5");
		System.out.println(getRanking("Spiderman"));
		System.out.println("------------test for getTopVideos------------------");
		List<String> list = getTopVideos();
		for(String s: list){
			System.out.println(s);
		}
	}

	public static void readInput()
	{
		// Read the input
		Scanner sc = new Scanner(System.in);
		int nbrOfHits = sc.nextInt();

		for(int i = 0; i < nbrOfHits; i++)
		{
			// input is in the form: videoViewed('xxxxxx')
			String inputLine = sc.nextLine();
			if(inputLine.startsWith("videoViewed")){
				inputLine = inputLine.substring(11);
				String texts[] = inputLine.split("'");
				String videoId = texts[0];
				videoViewed(videoId);
			}
		}
		sc.close();
	}

	public static void videoViewed(String videoId)
	{
		if(videoMap.containsKey(videoId))
		{
			Video video = videoMap.get(videoId);
			video.incNbrOfHits();
			videoMap.put(videoId, video);
		}
		else
		{
			Video video = new Video(videoId);
			videoMap.put(videoId, video);
			pq.add(video);
		}
		Iterator<Video> itr = pq.iterator();
		PriorityQueue<Video> localPq = new PriorityQueue<Video>(new VideoComparator());
		while(itr.hasNext())
		{
			localPq.add(itr.next());
		}

		int rank = 1;
		while(!localPq.isEmpty())
		{
			Video vid = localPq.poll();
			rankingMap.put(vid.getVideoId(), rank++);
		}
	}

	public static int getRanking(String videoId){
		int rank = -1;
		if(rankingMap.containsKey(videoId))
			return rankingMap.get(videoId);
		return rank;
	}

	public static List<String> getTopVideos(){
		//return top 10 videos
		List<String> retList = new ArrayList<String>();
		Iterator<Video> itr = pq.iterator();
		PriorityQueue<Video> localPq = new PriorityQueue<Video>(new VideoComparator());
		while(itr.hasNext())
		{
			localPq.add(itr.next());
		}

		int rank = 0;
		while(!localPq.isEmpty() && rank<10)
		{
			retList.add(localPq.poll().getVideoId());
			rank++;
		}
		return retList;
	}

}
