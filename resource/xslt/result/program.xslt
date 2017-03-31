<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
            <Program>
                <Title>
                    <ProperTitle>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Title/ProperTitle"/>
                    </ProperTitle>

                    <ParallelProperTitle>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Title/ParallelProperTitle"/>
                    </ParallelProperTitle>
                    <SubordinateTitle>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Title/SubordinateTitle"/>
                    </SubordinateTitle>
                    <AlternativeTitle>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Title/AlternativeTitle"/>
                    </AlternativeTitle>
                    <TitleDescription>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Title/TitleDescription"/>
                    </TitleDescription>
                    <Series>
                        <SeriesTitle>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Title/Series/SeriesTitle"/>
                        </SeriesTitle>
                        <ParallelSeriesTitle>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Title/Series/ParallelSeriesTitle"/>
                        </ParallelSeriesTitle>
                        <TotalNumberofEpisodes>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Title/Series/TotalNumberofEpisodes"/>
                        </TotalNumberofEpisodes>
                        <EpisodesNumber>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Title/Series/EpisodesNumber"/>
                        </EpisodesNumber>
                    </Series>
                </Title>
                <Subject>
                    <Class>
                        <Classification>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Subject/Class/Classification"/>
                        </Classification>
                        <ClassNumber>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Subject/Class/ClassNumber"/>
                        </ClassNumber>
                    </Class>
                    <SubjectTerm>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Subject/SubjectTerm"/>
                    </SubjectTerm>
                    <Keyword>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Subject/Keyword"/>
                    </Keyword>
                </Subject>
                <Description>
                    <DescriptionofContent>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/DescriptionofContent"/>
                    </DescriptionofContent>
                    <Character>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/Character"/>
                    </Character>
                    <DateofEvent>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/DateofEvent"/>
                    </DateofEvent>
                    <VersionDescription>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/VersionDescription"/>
                    </VersionDescription>
                    <Awards>
                        <NameofAwards>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/Awards/NameofAwards"/>
                        </NameofAwards>
                        <ItemofAwards>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/Awards/ItemofAwards"/>
                        </ItemofAwards>
                        <WinnersofAwards>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/Awards/WinnersofAwards"/>
                        </WinnersofAwards>
                        <YearorTimeofAwards>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/Awards/YearorTimeofAwards"/>
                        </YearorTimeofAwards>
                        <DateofAwards>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/Awards/DateofAwards"/>
                        </DateofAwards>
                    </Awards>

                    <Column>
                        <ColumnName>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/Column/ColumnName"/>
                        </ColumnName>
                        <IssueNumber>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/Column/IssueNumber"/>
                        </IssueNumber>
                        <IssueYear>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/Column/IssueYear"/>
                        </IssueYear>
                    </Column>
                    <Audience>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/Audience"/>
                    </Audience>
                    <AdditionalLogo>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/AdditionalLogo"/>
                    </AdditionalLogo>
                    <AudioChannel>
                        <AudioChannelNumber>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/AudioChannel/AudioChannelNumber"/>
                        </AudioChannelNumber>
                        <AudioChannelDescription>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Description/AudioChannel/AudioChannelDescription"/>
                        </AudioChannelDescription>
                    </AudioChannel>
                    <Attachment>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Description/Attachment"/>
                    </Attachment>
                </Description>
                <Creator>
                    <DescriptionofCreator>
                        <NameofCreator>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Creator/DescriptionofCreator/NameofCreator"/>
                        </NameofCreator>
                        <ParallelNameofCreator>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Creator/DescriptionofCreator/ParallelNameofCreator"/>
                        </ParallelNameofCreator>
                        <Role>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Creator/DescriptionofCreator/Role"/>
                        </Role>
                        <OtherInformation>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Creator/DescriptionofCreator/OtherInformation"/>
                        </OtherInformation>
                    </DescriptionofCreator>
                </Creator>
                <Contributor>
                    <DescriptionofContributor>
                        <NameofContributor>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Contributor/DescriptionofContributor/NameofContributor"/>
                        </NameofContributor>
                        <ParallelNameofContributor>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Contributor/DescriptionofContributor/ParallelNameofContributor"/>
                        </ParallelNameofContributor>
                        <Role>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Contributor/DescriptionofContributor/Role"/>
                        </Role>
                        <OtherInformation>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Contributor/DescriptionofContributor/OtherInformation"/>
                        </OtherInformation>
                    </DescriptionofContributor>
                </Contributor>
                <Copyright>
                    <DescriptionofAuthorizedUse>
                        <TimesofAuthorizedUsage>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Copyright/DescriptionofAuthorizedUse/TimesofAuthorizedUsage"/>
                        </TimesofAuthorizedUsage>
                    </DescriptionofAuthorizedUse>
                </Copyright>
                <Language>
                    <AudioChannel>
                        <AudioChannelNumber>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Language/AudioChannel/AudioChannelNumber"/>
                        </AudioChannelNumber>
                        <AudioChannelLanguage>
                            <xsl:value-of select="MetaData.Program.Language.AudioChannel.AudioChannelLanguage"/>
                        </AudioChannelLanguage>
                    </AudioChannel>
                    <Subtitle>
                        <SubtitleNumber>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Language/Subtitle/SubtitleNumber"/>
                        </SubtitleNumber>
                        <SubtitleLanguage>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Language/Subtitle/SubtitleLanguage"/>
                        </SubtitleLanguage>
                    </Subtitle>
                </Language>
                <Date>
                    <ProducedDate>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Date/ProducedDate"/>
                    </ProducedDate>
                    <DateofDebut>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Date/Debut/DateofDebut"/>
                    </DateofDebut>
                    <PublishedDate>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Date/PublishedDate"/>
                    </PublishedDate>
                </Date>
                <Type>
                    <ProgramType>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Type/ProgramType"/>
                    </ProgramType>
                    <ProgramForm>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Type/ProgramForm"/>
                    </ProgramForm>
                </Type>
                <Format>
                    <Duration>
                        <xsl:value-of select="CMS/MetaData/Clip/ClipBaseInfo/Duration"/>
                    </Duration>
                    <StartingPoint>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/StartingPoint"/>
                    </StartingPoint>
                    <Color>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/Color"/>
                    </Color>
                    <SubtitleForm>
                        <xsl:value-of select="MetaData.Program.Format.SubtitleForm"/>
                    </SubtitleForm>
                    <AudioChannelFormat>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioChannelFormat"/>
                    </AudioChannelFormat>
                    <AudioQuality>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioQuality"/>
                    </AudioQuality>
                    <VideoQuality>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/VideoQuality"/>
                    </VideoQuality>
                    <AspectRatio>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AspectRatio"/>
                    </AspectRatio>
                    <PhysicalMediaType>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/PhysicalMediaType"/>
                    </PhysicalMediaType>
                    <System>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/System"/>
                    </System>
                    <AudioDataRate>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioDataRate"/>
                    </AudioDataRate>
                    <AudioCodingFormat>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioCodingFormat"/>
                    </AudioCodingFormat>
                    <AudioSamplingFrequency>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioSamplingFrequency"/>
                    </AudioSamplingFrequency>
                    <AudioBitDepth>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/AudioBitDepth"/>
                    </AudioBitDepth>
                    <VideoBitrate>
                        <xsl:value-of select="CMS/MetaData/Clip/ClipBaseInfo/bitrate"/>
                    </VideoBitrate>
                    <VideoCodingFormat>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/VideoCodingFormat"/>
                    </VideoCodingFormat>
                    <VideoSamplingType>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Format/VideoSamplingType"/>
                    </VideoSamplingType>
                    <FileFormat>
                        <xsl:value-of select="CMS/MetaData/Clip/ClipFiles/ClipFile/ClipFileInfo/format"/>
                    </FileFormat>
                </Format>
                <Coverage>
                    <YearsCovered>
                        <YearofStart>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Coverage/YearsCovered/YearofStart"/>
                        </YearofStart>
                        <YearofEnd>
                            <xsl:value-of select="CMS/MetaData/Description/Program/Coverage/YearsCovered/YearofEnd"/>
                        </YearofEnd>
                    </YearsCovered>
                    <Spatial>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Coverage/Spatial"/>
                    </Spatial>
                </Coverage>
                <Source>
                    <AcquiringMethodofSource>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Source/AcquiringMethodofSource"/>
                    </AcquiringMethodofSource>
                    <SourceProvider>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Source/SourceProvider"/>
                    </SourceProvider>
                </Source>
                <Relation>
                    <PartofSeries>
                        <xsl:value-of select="MetaData.Program.Relation.AcquiringMethodofSource.PartofSeries"/>
                    </PartofSeries>
                    <IsPartof>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/IsPartof"/>
                    </IsPartof>
                    <HasPart>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/HasPart"/>
                    </HasPart>
                    <References>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/References"/>
                    </References>
                    <IsReferencedby>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/IsReferencedby"/>
                    </IsReferencedby>
                    <Replaces>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/Replaces"/>
                    </Replaces>
                    <IsReplacedby>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/IsReplacedby"/>
                    </IsReplacedby>
                    <Requires>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/Requires"/>
                    </Requires>
                    <IsRequiredby>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/IsRequiredby"/>
                    </IsRequiredby>
                    <IsVersionof>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/IsVersionof"/>
                    </IsVersionof>
                    <HasVersionof>
                        <xsl:value-of select="CMS/MetaData/Description/Program/Relation/HasVersionof"/>
                    </HasVersionof>
                </Relation>
            </Program>
        </MetaData>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>