package Frogg;

	public class Velocity {
		double xVelo;
		double yVelo;
		
		public Velocity(double xVelo, double yVelo) {
			this.xVelo = xVelo;
			this.yVelo = yVelo;
		}
		
		@Override
		public String toString() {
			return "Velocity: (" + xVelo + ", " + yVelo + ")";
		}
}