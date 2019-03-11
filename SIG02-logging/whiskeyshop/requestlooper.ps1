$ipport = Read-Host -Prompt 'Input your ip:port combination'

while($true)
{
	$requestinterval = Get-Random -Maximum 11
	$rnd = Get-Random -Maximum 3
	if ($rnd -eq 1) {
		curl http://${ipport}/whiskeys
	}
	elseif ($rnd -eq 2) {
		$rnd2 = Get-Random -Maximum 4
		if ($rnd2 -eq 1) {
			curl http://${ipport}/whiskeys/Jack
		}
		elseif ($rnd2 -eq 2) {
			curl http://${ipport}/whiskeys/Glenn
		}
		elseif ($rnd2 -eq 3) {
			curl http://${ipport}/whiskeys/Jameson
		}
	}
	Start-Sleep -s $requestinterval
}