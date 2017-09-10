<?php

process();

function process() {
	$start_time = microtime(true);
	
	// enable errors printing
	// comment this on release
	ini_set('display_errors', 1);
	error_reporting(E_ALL);

	$x = (float) $_POST['Xcor'];
	$y = (float) $_POST['Ycor'];
	$r = (float) $_POST['Rrad'];
	
	echo "Entered values:<br>
	<table>
		<tr> <td>x</td> <td>$x</td> </tr>
		<tr> <td>y</td> <td>$y</td> </tr>
		<tr> <td>r</td> <td>$r</td> </tr>
	</table><br>";
	
	if(is_point_in_region($x, $y, $r)) {
		echo "The point is in the region";
	} else {
		echo "The point isn't in the region";
	}
	echo "<br><br>";
	
	echo "Current date and time: ", date('h:i a F d, Y'), "<br>";
	$exec_time = microtime(true) - $start_time;
	echo sprintf("Script execution time: ~%.5f ms", $exec_time);
}


function is_point_in_region($x, $y, $r) : bool {
	if(
		// if in the rectangle
		($x <= $r and $x >= 0 and $y <= $r/2 and $y >= 0) or
	
		// if in the triangle
		($x >= 0 and $y >= 0 and 
			position_of_point($x, $y, 0, -$r, $r/2, 0) >= 1) or
	
		// if in a circle 
		($x >= 0 and $y <= 0 and distance_between(0, 0, $x, $y) <= $r)) {
			return true;
	}
	return false;
}


function position_of_point(
			$point_x, $point_y, 
			$line1_x, $line1_y,
			$line2_x, $line2_y) : int {
	return ($point_y - $line1_y) * ($line2_x - $line1_x) - 
			($point_x - $line1_x) * ($line2_y - $line1_y);
}


function distance_between($x1, $y1, $x2, $y2) : float {
	return sqrt(pow(2, $x2 - $x1) + pow(2, $y2 - $y1));
}
?>

