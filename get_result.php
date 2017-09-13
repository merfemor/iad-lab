<?php

$start_time = microtime(true);

// enable errors printing
// comment this on release
ini_set('display_errors', 1);
error_reporting(E_ALL);

$is_cur_input_valid = isset($_POST['Xcor']) && isset($_POST['Ycor']) && isset($_POST['Rrad']);

if($is_cur_input_valid) {
    echo "<style>
    TD, TH {
    border: 1px solid;
        padding: 8px;
    }
    TABLE {
       
    }
</style>";
    echo "<b>Entered values</b>:<br>
	<table cellspacing='1'>
		<tr> <td>x</td> <td>", $_POST['Xcor'], "</td> </tr>
		<tr> <td>y</td> <td>", $_POST['Ycor'], "</td> </tr>
		<tr> <td>r</td> <td>", $_POST['Rrad'], "</td> </tr>
	</table><br>";
    $is_cur_input_valid = is_number($_POST['Xcor']) &&
            is_number($_POST['Ycor']) &&
            is_number($_POST['Rrad']);
}

if($is_cur_input_valid) {
    $x = intval($_POST['Xcor']);
    $y = floatval($_POST['Ycor']);
    $r = floatval($_POST['Rrad']);

    $is_cur_input_valid = (in_array($x, array(-5, -4, -3, -2, -1, 0, 1, 2, 3)) &&
        $y <= 3 && $y >= -5 && $r >= 2 && $r <= 5);
}

$result = false;

if($is_cur_input_valid) {
    $result = is_point_in_region($x, $y, $r);
    echo "The point is in the region: <font color=\"";
    if($result) {
        echo "green\"><b>true</b>";
    } else {
        echo "red\"><b>false</b>";
    }
    echo "</font>";
    echo "<br>";
    print_prev_data();

} else {
    echo '<img src="pics/wat.jpg"><br><br>';
    echo '<b>Incorrect input!</b> <br>
			x should be in {-5, -4, -3, -2, -1, 0, 1, 2, 3} <br>
			y should be between -5 and 3 <br>
			r should be between 2 and 5 <br>';
}

$cur_date = date('h:i a F d, Y');
echo "<hr><i><ins>Current date and time</ins></i>: ", $cur_date, "<br>";
$exec_time = microtime(true) - $start_time;
echo sprintf("<i><ins>Script execution time</ins></i>: ~%.5f ms", $exec_time);

if($is_cur_input_valid) {
    save_data($x, $y, $r, $result, $cur_date, $exec_time);
}

function save_data($x, $y, $r, $result, $date, $exec_time) {
	$data = implode(';', array($x, $y, $r, (int)$result, $date, $exec_time));
    file_put_contents(get_user_filename(), $data . "|", FILE_APPEND);
}

function print_prev_data() {
    if(!file_exists(get_user_filename())) {
        return;
    }
    echo "<p><b>Previous inputs</b>:";
    echo "<table>
          <tr>
            <td>#</td> <td>x</td> <td>y</td> <td>r</td> <td>result</td> <td>date</td> <td>exec.time</td>
          </tr>";

    $content = file_get_contents(get_user_filename());
    $lines = explode('|', $content);

    for($line = 1; $line <= count($lines); $line++) {
        if(empty($lines[$line - 1])) {
            continue;
        }
        echo "<tr><td>$line</td>";
        $args = explode(';', $lines[$line - 1]);
        for ($n = 0; $n < count($args); $n++) {
            echo "<td>";
            if($n == 3) {
                if($args[$n]) {
                    echo "<font color='green'>true</font>";
                } else {
                    echo "<font color='red'>false</font>";
                }
            } else if($n == 5) {
                echo sprintf("%.5f ms", $args[$n]);
            } else {
                echo $args[$n];
            }
            echo "</td>";
        }
        echo "</tr>";
    }

    echo "</table>";
    echo "</p>";
}

function get_user_filename() {
    return "logs/" . get_client_ip() . ".txt";
}


function is_point_in_region($x, $y, $r) {
	if(
		// if in the rectangle
		($x <= $r && $x >= 0 && $y <= $r/2 && $y >= 0) or
	
		// if in the triangle
		($x >= 0 && $y >= 0 && 
			position_of_point($x, $y, 0, -$r, $r/2, 0) >= 1) or
	
		// if in a circle 
		($x >= 0 && $y <= 0 && distance_between(0, 0, $x, $y) <= $r)) {
			return true;
	}
	return false;
}


function position_of_point(
			$point_x, $point_y, 
			$line1_x, $line1_y,
			$line2_x, $line2_y) {
	return ($point_y - $line1_y) * ($line2_x - $line1_x) - 
			($point_x - $line1_x) * ($line2_y - $line1_y);
}


function distance_between($x1, $y1, $x2, $y2) {
	return sqrt(pow(2, $x2 - $x1) + pow(2, $y2 - $y1));
}

function is_number($var) {
    return is_numeric($var) && strval(floatval($var)) === $var;
}

// Function to get the client IP address
function get_client_ip() {
    $ipaddress = '';
    if (getenv('HTTP_CLIENT_IP'))
        $ipaddress = getenv('HTTP_CLIENT_IP');
    else if(getenv('HTTP_X_FORWARDED_FOR'))
        $ipaddress = getenv('HTTP_X_FORWARDED_FOR');
    else if(getenv('HTTP_X_FORWARDED'))
        $ipaddress = getenv('HTTP_X_FORWARDED');
    else if(getenv('HTTP_FORWARDED_FOR'))
        $ipaddress = getenv('HTTP_FORWARDED_FOR');
    else if(getenv('HTTP_FORWARDED'))
        $ipaddress = getenv('HTTP_FORWARDED');
    else if(getenv('REMOTE_ADDR'))
        $ipaddress = getenv('REMOTE_ADDR');
    else
        $ipaddress = 'UNKNOWN';
    return $ipaddress;
}

?>

