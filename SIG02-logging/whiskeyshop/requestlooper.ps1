$port = 9000
$requestinterval = 5

while($true)
{
	$rnd = Get-Random -Maximum 3
	if ($rnd -eq 1) {
		curl http://localhost:$port/whiskeys
	}
	elseif ($rnd -eq 2) {
		$rnd2 = Get-Random -Maximum 4
		if ($rnd2 -eq 1) {
			curl http://localhost:$port/whiskeys/Jack
		}
		elseif ($rnd2 -eq 2) {
			curl http://localhost:$port/whiskeys/Glenn
		}
		elseif ($rnd2 -eq 3) {
			curl http://localhost:$port/whiskeys/Jameson
		}
	}
	Start-Sleep -s $requestinterval
}