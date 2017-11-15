package mars.exploration.rovers;

import mars.exploration.rovers.vo.MarsRoverVO;

public class MarsRover
{
	static public MarsRover getInstance()
	{
		return new MarsRover();
	}

	public String[] moveRover(String directions)
			throws IllegalArgumentException, ArrayIndexOutOfBoundsException
	{
		MarsRoverVO rover = new MarsRoverVO();

		String[] commands = directions.split("");
		for (int i = 0; i < commands.length; i++)
		{
			moveTo(commands[i], rover);
		}

		return rover.getPosition();
	}

	public void moveTo(String command, MarsRoverVO rover)
			throws IllegalArgumentException, ArrayIndexOutOfBoundsException
	{
		switch (command.toUpperCase())
		{
			case "L":
				rover.rotateLeft();
				break;
			case "R":
				rover.rotateRight();
				break;
			case "M":
				rover.moveForwards();
				break;

			default:
				throw new IllegalArgumentException("O comando digitado é inválido.");
		}
		if (!validateRoverPosition(rover))
			throw new ArrayIndexOutOfBoundsException(
					"O robô não pode ultrapassar o terreno definido (5x5)");
	}

	public String parsePositionToString(String[] position)
	{
		String returnPosition = position[0] + ", " + position[1] + ", " + position[2];

		return returnPosition;
	}

	public Boolean validateRoverPosition(MarsRoverVO rover)
	{
		if (rover.getX() >= 5 || rover.getY() >= 5 || rover.getX() < 0 || rover.getY() < 0)
			return false;

		return true;
	}
}
