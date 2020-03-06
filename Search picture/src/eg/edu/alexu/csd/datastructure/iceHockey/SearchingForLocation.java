package eg.edu.alexu.csd.datastructure.iceHockey;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class SearchingForLocation {

	@Test
	void test() {
		try {
			
			findPlayers input=new findPlayers();
			
			String []s1= {"8D88888J8L8E888",
					"88NKMG8N8E8JI88", 
					"888NS8EU88HN8EO", 
					"LUQ888A8TH8OIH8", 
					"888QJ88R8SG88TY",
					"88ZQV88B88OUZ8O",
					"FQ88WF8Q8GG88B8",
					"8S888HGSB8FT8S8", 
					"8MX88D88888T8K8", 
					"8S8A88MGVDG8XK8", 
					"M88S8B8I8M88J8N",
					"8W88X88ZT8KA8I8", 
					"88SQGB8I8J88W88",
					"U88H8NI8CZB88B8",
					"8PK8H8T8888TQR8" };
			String []s2= {""};
			String []s3={ "33JUBU33","3U3O4433", "O33P44NB", "PO3NSDP3", 
					"VNDSD333", "OINFD33X"};
			String []s4={ "44444H44S4", "K444K4L444", "4LJ44T44XH", 
					"444O4VIF44", "44C4D4U444", "4V4Y4KB4M4", "G4W4HP4O4W", 
					"4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444" };
			String []s5={"11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
			Point []p1= {new Point(3,3),new Point(9,2),new Point(18,3),new Point(27,2),
					new Point(10,9),new Point(3,10),new Point(18,11),new Point(8,17),
					new Point(24,15),new Point(29,16),new Point(1,17),new Point(17,16),
					new Point(5,21),new Point(22,20),new Point(12,23),new Point(3,25),
					new Point(28,26),new Point(23,26),new Point(18,28)};
			Point []p2=input.findPlayers(s1,8,9);
			assertArrayEquals(p2,p1);
			Point []p3=input.findPlayers(s2,8,9);
		    assertEquals("Image is empty",p3);
			Point []p4= {new Point(4,5),new Point(13,9),new Point(14,2)};
			Point []p5=input.findPlayers(s3, 3,16);
			assertEquals(p5,p4);
			Point []p6= { new Point(3,8), new Point(4,16),new Point (5,4),
					new Point(16,3), new Point(16,17), new Point(17,9) };
			Point []p7=input.findPlayers(s4, 4,16);
			assertArrayEquals(p7,p6);
			Point []p8= {new Point(5,5),new Point(5,5)};
			Point []p9=input.findPlayers(s5, 1,3);
			assertArrayEquals(p9,p8);
			Point []p10=input.findPlayers(s1, 1,16);
            assertEquals("Error",p10);
		} catch (Exception e) {
			System.out.println("Image is empty");
		}
		
	}

}
