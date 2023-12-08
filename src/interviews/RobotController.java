package interviews;

import java.util.Random;

public class RobotController {

	private final int limitThreshold;
	private final Robot robot;

	public RobotController(final int limitThreshold, final Robot robot) {
		this.robot = robot;
		this.limitThreshold = limitThreshold;
	}

	public void move() throws LimitExceededException {
		int currentStep = 0;
		int times = limitThreshold;
		while (!(currentStep == 1)) {
			boolean result = robot.move();
			if (result) {
				currentStep++;
			} else {
				currentStep--;
				times--;
			}
			if (times == 0) throw new LimitExceededException("Limit Exceeds");
		}
	}

	public static void main(String[] args) throws LimitExceededException {
		RobotController robotController = new RobotController(1, new ClimbingRobot());
		robotController.move();
	}
}

class LimitExceededException extends Exception {
	public LimitExceededException(String message) {
		super(message);
	}
}

interface Robot {
	public boolean move();
}

class ClimbingRobot implements Robot {
	public boolean move() {
		int randomNumber = new Random().nextInt(100);
		return randomNumber % 2 == 0;
	}
}
