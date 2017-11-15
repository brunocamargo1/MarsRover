package mars.exploration.rovers;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MarsRoverTest
{
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testRoverDirections()
	{
		MarsRover mr = MarsRover.getInstance();

		assertEquals("1, 1, S", mr.parsePositionToString(mr.moveRover("MMRMMLLMRRRM")));
		assertEquals("0, 2, W", mr.parsePositionToString(mr.moveRover("MML")));
		assertEquals("2, 0, S", mr.parsePositionToString(mr.moveRover("MMRMMRMM")));
	}

	@Test
	public void testRoverBounds()
	{
		MarsRover mr = MarsRover.getInstance();
		exception.expect(ArrayIndexOutOfBoundsException.class);
		exception.expectMessage("O robô não pode ultrapassar o terreno definido (5x5)");
		mr.moveRover("MMMMMMMM");

		exception.expect(NullPointerException.class);
		exception.expectMessage("O comando digitado é inválido.1");
		mr.moveRover("AAA");
	}

	@Test
	public void testRoverCommands()
	{
		MarsRover mr = MarsRover.getInstance();

		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("O comando digitado é inválido.");
		mr.moveRover("AAA");
	}
}
