import java.awt.*;
import java.util.Random;

public class PlayGround {
	public Enemy[] enemies = new Enemy[5];
	public Shot[] shots = new Shot[10];
	public Player player;
	Color color;
	public boolean exit= false;
	PlayGround(){
		for (int i = 0; i < 5; i++) {
			Random r = new Random();
			enemies[i] = new Enemy(r.nextDouble(), 1.0, "images/enemy.png");
		}
		StdDraw.setCanvasSize(800, 600);
		player = new Player(0.5, 0.2, "images/player.png");
		color = new Color(29,17,53);
	}
	public void GameOver() {
		 Random rand = new Random();
		 player.setPosX(-500);
		 player.setPosY(-500);
		 Font font = new Font("Arial", Font.BOLD, 60);
		 StdDraw.setFont(font);
		 StdDraw.text(0.5, 0.5, "GAME OVER");
		 StdDraw.pause(15);
		 exit=true;
	}
	
	
	public void draw() {
		int i = 0;
		int shotCount = 0;
		int score = 0;
		while(!exit) {
			StdDraw.clear(color);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(0.100, 0.96, "Score: " + score);
			if (StdDraw.mousePressed()) {
				Shot a = new Shot(player);
				shots[shotCount] = a;
				shotCount++;
				if(shotCount > 8) {
					shotCount = 0;
				}
			}

			for(Shot s : shots) { // INITIALLY CHECKS FOR SHOTS AND MOVES THE SHOTS
				if(s == null) {
					break;
				}
				else {
					s.move();
				}
			}
			
			for (Enemy e : enemies) {		//CHECKS EVERY ENEMY 
				if(player.collide(e) == 1) {	//CHECKS WHETHER THE PLAYER COLLIDED WITH THE ENEMY
					GameOver();
				}
				for(Shot a : shots) {			//CHECKS WHETEHER THE SHOT HAS SUCCESFULLY LANDED ON THE ENEMY
					if(a == null) {
						break;
					}
					else {
						if (a.collide(e)) {		//UPDATES THE POSITION OF THE DESTROYED ENEMY
							Random rand = new Random();
							e.setPosX(rand.nextDouble());
							e.setPosY(1);
							score++;							
						}
					}
				}
				if(e.getPosY() < 0) {			//CHECKS WHETHER THE ENEMY IS OUT OF BOUNDS. IF YES, SPAWN AGAIN
					Random rand = new Random();
					e.setPosX(rand.nextDouble());
					e.setPosY(1);
				}
				e.animate();
			}
			
			player.draw();
			player.move();
			StdDraw.pause(30);
		}
	}
	
}