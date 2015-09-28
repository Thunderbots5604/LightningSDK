/* Copyright (C) 2015-2016 Thunderbots Robotics
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.thunderbots.lightning.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * A {@code Motor} represents any physical DC motor that is connected to the robot.
 *
 * @author Pranav Mathur
 * @author Zach Ohara
 */
public class Motor extends DcMotor {

	public Motor(DcMotorController controller, int portNumber) {
		super(controller, portNumber);
	}

	/**
	 * The encoder that is attached to this motor. This will always be a defined, valid
	 * object, even if there is no encoder attached to this motor.
	 */
	private Encoder encoder;
	
	private double power;

	/**
	 * The maximum power of the motor.
	 */
	public static final double MAX_POWER = 1;

	/**
	 * The power of the motor when the motor is at rest.
	 */
	public static final double REST_POWER = 0;

	/**
	 * The maximum power of the motor when the motor is spinning backwards.
	 */
	public static final double MIN_POWER = -1;

	/**
	 * Gets the encoder attached to this motor. This will return an {@code Encoder} even if
	 * there is no physical encoder attached to the physical motor.
	 *
	 * @return the encoder on this motor.
	 */
	public Encoder getEncoder() {
		return this.encoder;
	}

	/**
	 * Gets the raw encoder position value of this motor.
	 *
	 * @return the raw encoder value of this motor.
	 */
	public int getRawPosition() {
		return super.getCurrentPosition();
	}

	/**
	 * Determines if the motor's output direction is reversed from its inputs.
	 *
	 * @return {@code true} if the motor's output is reversed from its inputs, or
	 * {@code false} if the motor's ouput has the same polarity as its input.
	 */
	public boolean isReversed() {
		return super.getDirection() == DcMotor.Direction.REVERSE;
	}

	/**
	 * Sets if the motor's output direction is reversed from its inputs.
	 *
	 * @param reversed {@code true} if the motor's output is reversed from its inputs, or
	 * {@code false} if the motor's ouput has the same polarity as its input.
	 */
	public void setReversed(boolean reversed) {
		if (reversed) {
			super.setDirection(DcMotor.Direction.REVERSE);
		} else {
			super.setDirection(DcMotor.Direction.FORWARD);
		}
	}

	/**
	 * Gets the current movement power of this motor.
	 *
	 * @return the current movement power; between -1 and 1.
	 */
	public double getPower() {
		try {
			return super.getPower();
		} catch (Exception e) {
			return this.power;
		}
	}

	public Motor(DcMotorController controller, int portNumber, Direction direction) {
		super(controller, portNumber, direction);
	}

	/**
	 * Sets the movement power of this motor.
	 *
	 * @param power the movement power; between -1 and 1.
	 */
	public void setPower(double power) {
		super.setPower(power);
		this.power = power;
	}
	
	/**
	 * Stops the motor. If the motor is not currently moving, this method has no effect.
	 */
	public void stop() {
		this.setPower(Motor.REST_POWER);
	}

}
