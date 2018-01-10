<!DOCTYPE html>
<html>
	<head>
		<style type="text/css">
			.tg {
				border-collapse: collapse;
				border-spacing: 0;
			}
			
			.tg td {
				font-family: 'SimSun';
				font-size: 14px;
				padding: 16px 5px;
				border-style: solid;
				border-width: 1px;
				overflow: hidden;
				word-br/eak: normal;
			}
			
			.tg th {
				font-family:'SimSun';
				font-size: 14px;
				font-weight: normal;
				padding: 16px 5px;
				border-style: solid;
				border-width: 1px;
				overflow: hidden;
				word-break: normal;
			}
			
			.tg .tg-s6z2 {
				text-align: center
			}
			
			.tg .tg-baqh {
				text-align: center;
				vertical-align: top
			}
			
			.tg .tg-yw4l {
				vertical-align: center;
			}
			
			.tg .tg-noborder {
				border:none;
			}
			
			.tg-032e{
			   font-family: 'HYT_OMR_Small';
			}
		</style>
	</head>

	<body style="font-family:'SimSun'">
		<div style="width: 650px;margin: 0 auto;">
		<h4 style="text-align: center;">Interview Assessment Form</h4>
		<table class="tg" style="width: 100%;table-layout: fixed; word-break:break-strict;">
			<tr>
				<td class="tg-031e" colspan="5">Candidate:<span class="tg-032e">${candidate}</span></td>
				<td class="tg-031e" colspan="5">Position:<span  class="tg-032e">${position}</span></td>
			</tr>
			<tr>
				<td class="tg-031e" colspan="5" >Source:<span>${source}</span></td>
				<td class="tg-031e" colspan="5">Last Interview Date:<span  class="tg-032e">${lastInterviewDate}</span></td>
			</tr>
			<tr>
				<td class="tg-031e" colspan="2">Paper Test</td>
				<td class="tg-031e" colspan="8"><span  class="tg-032e">${testPaper}</span></td>
			</tr>
			<tr>
				<td class="tg-031e" colspan="2">Test Date</td>
				<td class="tg-s6z2">IQ<br/>Single<br/>choice</td>
				<td class="tg-s6z2">IQ<br/>Multiple<br/>choice</td>
				<td class="tg-s6z2">Logical<br/>Single<br/>choice</td>
				<td class="tg-s6z2">Logical<br/>Multiple<br/>choices</td>
				<td class="tg-s6z2">English<br/>short<br/>answer</td>
				<td class="tg-s6z2">JAVA<br/>program-<br/>ming</td>
				<td class="tg-s6z2">.NET<br/>program-<br/>ming</td>
				<td class="tg-baqh">Total<br/>Score</td>
			</tr>
			<tr>
				<td class="tg-s6z2" colspan="2" rowspan="3"><span>${testDate}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${iqSingleScore}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${iqMultipleScore}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${logicalSingleScore}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${logicalMultipleScore}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${englishScore}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${javaProScore}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${netProScore}</span></td>
				<td class="tg-s6z2" rowspan="3"><span  class="tg-032e">${totalScore}</span></td>
			</tr>
			<tr>
				<td class="tg-s6z2">Comment</td>
				<td class="tg-s6z2">Comment</td>
				<td class="tg-s6z2">Comment</td>
				<td class="tg-s6z2">Comment</td>
				<td class="tg-s6z2">Comment</td>
				<td class="tg-s6z2">Comment</td>
				<td class="tg-s6z2">Comment</td>
			</tr>
			<tr>
				<td class="tg-s6z2"><span  class="tg-032e">${iqSingleCom}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${iqMultipleCom}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${logicalSingleCom}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${logicalMultipleCom}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${englishCom}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${javaProCom}</span></td>
				<td class="tg-s6z2"><span  class="tg-032e">${netProCom}</span></td>
			</tr>
			<tr>
				<td class="tg-s6z2" colspan="2" rowspan="6">First interview</td>
				<td class="tg-031e" colspan="4">Verbal English -40</td>
				<td class="tg-yw4l" colspan="4"><span  class="tg-032e">${verbalEngScore}</span></td>
			</tr>
			<tr>
				<td class="tg-031e" colspan="4">Optional -40</td>
				<td class="tg-yw4l" colspan="4"><span  class="tg-032e">${optionalScore}</span></td>
			</tr>
			<tr>
				<td class="tg-031e" colspan="4">MAP -30</td>
				<td class="tg-yw4l" colspan="4"><span  class="tg-032e">${mapScore}</span></td>
			</tr>
			<tr>
				<td class="tg-031e" colspan="4">Total Score -110</td>
				<td class="tg-yw4l" colspan="4"><span  class="tg-032e">${firstIntTotalScore}</span></td>
			</tr>
			<tr>
				<td class="tg-031e" colspan="8" rowspan="2">Comments:<span>${firstIntComment}</span><br/><br/>
				<span style="vertical-align: bottom;float: right;">Interviewer:${firstInterviewer}</span></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="tg-s6z2" colspan="2" rowspan="3">Second interview</td>
				<td class="tg-031e" colspan="8" rowspan="3">Comments:<span>${secondIntComment}</span><br/><br/>
					<span style="vertical-align: bottom;float: right;">Interviewer:${secondInterviewer}</span>
				</td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="tg-s6z2" colspan="2" rowspan="3">Third interview</td>
				<td class="tg-031e" colspan="8" rowspan="3">Comments:<span>${thirdIntComment}</span><br/><br/>
					<span style="vertical-align: bottom;float: right;">Interviewer:${thirdInterviewer}</span>
				</td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="tg-031e" colspan="10"> Final Suggestion:<span>${finalSuggestion}</span><br/></td>
			</tr>
			<tr>
				<td class="tg-noborder" colspan="5">Applicant decision:<span>${decision}</span></td>
				<td class="tg-noborder" colspan="5">Reason:<span>${reason}</span></td>
			</tr>
		</table>
		</div>
	</body>
</html>