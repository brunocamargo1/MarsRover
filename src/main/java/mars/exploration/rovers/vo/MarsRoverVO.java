package mars.exploration.rovers.vo;

import java.util.Arrays;

public class MarsRoverVO
{
	private Integer x;
	private Integer y;
	private String direction;
	String[] directions = new String[]{"N", "E", "S", "W"};
	
	public MarsRoverVO()
	{
		x = 0;
		y = 0;
		direction = "N";
	}

	public MarsRoverVO setPosition(Integer x, Integer y)
	{
		setX(x);
		setY(y);
		
		return this;
	}
	
	public String[] getPosition()
	{
		String[] position = new String[]{getX().toString(), getY().toString(), getDirection().toUpperCase()};		
		return position;
	}

	public String getDirection()
	{
		return direction;
	}

	public void setDirection(String direction)
	{
		this.direction = direction;
	}
	
	public MarsRoverVO rotateLeft()
	{
		Integer directionIndex = Arrays.asList(directions).indexOf(getDirection().toUpperCase());
		
		if (directionIndex == 0)
			setDirection(directions[3]);			
		else
			setDirection(directions[directionIndex-1]);
			
		return this;
	}
	
	public MarsRoverVO rotateRight()
	{
		Integer directionIndex = Arrays.asList(directions).indexOf(getDirection().toUpperCase());
		
		if (directionIndex == 3)		
			setDirection(directions[0]);
		else
			setDirection(directions[directionIndex+1]);			
			
		return this;
	}
	
	public MarsRoverVO moveForwards()
	{
		Integer directionIndex = Arrays.asList(directions).indexOf(getDirection().toUpperCase());
		
		switch (directionIndex)
		{
			case 0:
				y++;
				break;
			case 1:
				x++;
				break;
			case 2:
				y--;
				break;
			case 3:
				x--;
				break;
		}
		
		return this;
	}
	
	public MarsRoverVO moveBackwards()
	{
		Integer directionIndex = Arrays.asList(directions).indexOf(getDirection().toUpperCase());
		
		switch (directionIndex)
		{
			case 0:
				y--;
				break;
			case 1:
				x--;
				break;
			case 2:
				y++;
				break;
			case 3:
				x++;
				break;

			default:
				break;
		}
		
		return this;
	}

	public Integer getX()
	{
		return x;
	}

	public void setX(Integer x)
	{
		this.x = x;
	}

	public Integer getY()
	{
		return y;
	}

	public void setY(Integer y)
	{
		this.y = y;
	}
}
